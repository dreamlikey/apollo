### 代码简洁之道

日常代码的优化重构示例

#### DTO转化

保证代码简洁性、可读性（语义）

正如我们所知，DTO为系统与外界交互的模型对象，那么肯定会有一个步骤是将DTO对象转化为BO对象或者是普通的entity对象，让service层去处理

##### 场景

比如添加会员操作，由于用于演示，我只考虑用户的一些简单数据，当后台管理员点击添加用户时，只需要传过来用户的姓名和年龄就可以了，后端接受到数据后，将添加创建时间和更新时间和默认密码三个字段，然后保存数据库。

```java
@RequestMapping("/v1/api/user")
@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(UserInputDTO userInputDTO){
        User user = new User();
        user.setUsername(userInputDTO.getUsername());
        user.setAge(userInputDTO.getAge());

        return userService.addUser(user);
    }
}
```

我们只关注一下上述代码中的转化代码，其他内容请忽略:

```java
User user = new User();
user.setUsername(userInputDTO.getUsername());
user.setAge(userInputDTO.getAge());
```



上面这段代码没有逻辑问题，但是每个字段去set很繁琐，如果字段有几十个代码会很冗长和复杂而且容易出错。

##### 使用工具

我们可以使用`org.springframework.beans.BeanUtils#copyProperties`对代码进行重构和优化:

```java
@PostMapping
public User addUser(UserInputDTO userInputDTO){
    User user = new User();
    BeanUtils.copyProperties(userInputDTO,user);

    return userService.addUser(user);
}
```

BeanUtils#copyProperties是浅拷贝，对象转化时设置两个属性名一致并保证类型一致就可以了



##### 转化语义



```java
@PostMapping
public User addUser(UserDTO userDto){
   User user = convertFor(userDto);
   return userService.addUser(user);
}

public static User convertFor(UserDTO userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto,user);
    return user;
}
```

convertFor转化为，这样修改后语义变得明确



##### 抽象接口定义

当实际工作中，完成了几个api的DTO转化时，我们会发现，这样的操作有很多很多，那么应该定义好一个接口，让所有这样的操作都有规则的进行。

接口

```java
//通用接口，T target R resource
public interface DTOConvert<T,R> {
    T convert(R r);
}
```

实现

```java
public class UserDTOConvert implements DTOConvert<User, UserDTO> {
    @Override
    public User convert(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
```

调用

```java
@PostMapping
public User addUser(UserInputDTO userInputDTO){
   User user = new User();
   User user = new UserDTOConvert().convert(userDto);
   return userService.addUser(user);
}
```



##### review

```java
@Data
public class UserDTO {
    private String username;
    private Integer age;

    /**
     * 转换为
     * @return
     */
    public User convertFor() {
        UserDTOConverter converter = new UserDTOConverter();
        return converter.doForward(this);
    }

    /**
     * 转换自
     * @param user
     * @return
     */
    public UserDTO convertToUser(User user) {
        UserDTOConverter converter = new UserDTOConverter();
        return converter.doBackward(user);
    }

    private static class UserDTOConverter implements Converter<User, UserDTO> {

        @Override
        public User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        public UserDTO doBackward(User user) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }
    }
}
```



调用

```java
@PostMapping
 public UserDTO addUser(UserDTO userDTO){
         User user =  userDTO.convertToUser();
         User saveResultUser = userService.addUser(user);
         UserDTO result = userDTO.convertFor(saveResultUser);
         return result;
 }
```



当然，上述只是表明了转化方向的正向或逆向，很多业务需求的出参和入参的DTO对象是不同的，那么你需要更明显的告诉程序：逆向是无法调用的:

```java
private static class UserDTOConvert extends Converter<UserDTO, User> {
         @Override
         protected User doForward(UserDTO userDTO) {
                 User user = new User();
                 BeanUtils.copyProperties(userDTO,user);
                 return user;
         }

         @Override
         protected UserDTO doBackward(User user) {
                 throw new AssertionError("不支持逆向转化方法!");
         }
 }
```

看一下doBackward方法，直接抛出了一个断言异常，而不是业务异常，这段代码告诉代码的调用者，这个方法不是准你调用的，如果你调用，我就”断言”你调用错误了。