package com.wdq.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.wdq.apollo.entity.User;
import com.wdq.apollo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@EnableApolloConfig
@SpringBootApplication
public class ApolloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Value("${test.input}")
	private String input;

	@Value("${test.input1}")
	private String input1;

	@Override
	public void run(String... args) throws Exception {
		System.err.println("test.input 值 ENC(Ore69lUopDHL5R8Bw/G3bQ==) 解密后:" + input);
		System.err.println("test.input1 不需要解密:" + input1);

		Executors.newSingleThreadExecutor().submit(new Runnable() {
			@Override
			public void run() {
				while (true) {
					Optional<User> user = userRepository.findById(1);
					System.out.println(user.toString());
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
