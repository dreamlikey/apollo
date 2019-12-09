package com.wdq.reactive;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingDouble;

public class HelloReactive {

    private static List<Invoice> invoices = new ArrayList<>();
    static {
        Invoice invoice1 = new Invoice(1, 100.1, "Training", "USA",Customer.ORACLE);
        Invoice invoice2 = new Invoice(2, 1100.1, "Working", "CN", Customer.SUN);
        Invoice invoice3 = new Invoice(3, 1200.1, "Training", "USA", Customer.ORACLE);
        Invoice invoice4 = new Invoice(4, 1030.1, "Training", "CN", Customer.ORACLE);
        Invoice invoice5 = new Invoice(5, 1010.1, "Training", "CN",Customer.ORACLE);
        Invoice invoice6 = new Invoice(6, 10310.1, "Training", "UK",Customer.ORACLE);
        Invoice invoice7 = new Invoice(7, 210.1, "Ending", "CN", Customer.SUN);
        Invoice invoice8 = new Invoice(8, 410.1, "Training", "USA", Customer.ORACLE);
        invoices.add(invoice1);
        invoices.add(invoice2);
        invoices.add(invoice3);
        invoices.add(invoice4);
        invoices.add(invoice5);
        invoices.add(invoice6);
        invoices.add(invoice7);
        invoices.add(invoice8);
    }
    public static void main(String[] args) {
        getTop5(invoices);
        getTop5Stream(invoices);

        group$2();
    }

    public static List<Invoice> getTop5Stream(List<Invoice> invoices) {
        /**
         * 消费者类型:ORACLE
         * 消费方式:Training
         * 消费金额排序
         * 取前5条
         */
        Stream sortedInvoices = invoices.stream()
                .filter(inv -> inv.getCustomer() == Customer.ORACLE)
                .filter(inv -> inv.getTitle().contains("Training"))
                .sorted(comparingDouble(Invoice::getAmount))
                .limit(5);
        List<Invoice> list = (List<Invoice>) sortedInvoices.collect(Collectors.toList());

        /**
         * 最大金额
         */
        List<Double> amountList = invoices.stream().map(inv -> inv.getAmount()).collect(Collectors.toList());
        double max = amountList.stream().reduce(0.0, Double::max);
        System.out.println("max amount :" + max);

//        BinaryOperator<Double> accumulator = Double::max;

        /**
         * 金额之和
         */
        double sum = amountList.stream().reduce(0.0,(a, b) -> a+b);
        System.out.println("sum amount :" + sum);

        return list;
    }

    public static void getTop5(List<Invoice> invoices) {
        List<Invoice> oracleAndTrainingInvoices = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        List<Integer> firstFiveIds = new ArrayList<>();
        for(Invoice inv: invoices) {
            if(inv.getCustomer() == Customer.ORACLE) {
                if(inv.getTitle().contains("Training")) {
                    oracleAndTrainingInvoices.add(inv);
                }
            }
        }
        Collections.sort(oracleAndTrainingInvoices,
                new Comparator<Invoice>() {
                    @Override
                    public int compare(Invoice inv1, Invoice inv2) {
                        return Double.compare(inv1.getAmount(), inv2.getAmount());
                    }
                });
        for(Invoice inv : oracleAndTrainingInvoices) {
            ids.add(inv.getId());
        }
        for(int i = 0; i < 5; i++) {
            firstFiveIds.add(ids.get(i));
        }
        System.out.println(firstFiveIds);
    }

    public void group$1() {
//        Map<String, List<Invoice>> countMap = invoices.stream().collect(Collectors.groupingBy(inv -> inv.getTitle()));
//        List<Invoice> invoices = new ArrayList<Invoice>();
//        countMap.keySet().forEach(productType -> {
//                    Map<String, Long> countMap1 = countMap.get(productType).stream()
//                    .collect(Collectors.groupingBy(inv -> o.getCountry(), Collectors.counting()));
//                    countMap1(key).stream().forEach(country -> {
//                        Invoice record = new Invoice();
//                        record.set("device_type", productType);
//                        record.set("location", country);
//                        record.set("count", countMap1(key).intValue());
//                        records.add(record);
//                    });
//        });
    }

    public static void group$2() {
        // 分组统计
        Map<String, Long> countMap = invoices.stream().collect(Collectors.groupingBy(inv -> inv.getTitle() + "_" + inv.getCountry(), Collectors.counting()));
        List<Invoice> countRecords = countMap.keySet().stream().map(key -> {
            String[] temp = key.split("_");
            String productType = temp[0];
            String country = temp[1];

            Invoice invoice = new Invoice();
//            record.set("device_type", productType);
//            record.set("location", country);
//            record.set("count", countMap.get(key).intValue());
            return invoice;
        }).collect(Collectors.toList());
    }
}


class Invoice {
    private int id;
    private double amount;
    private String title;
    private String country;
    private Customer customer;

    public Invoice() {
    }

    public Invoice(int id, double amount, String title, String country, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.country = country;
        this.customer = customer;
    }

    public Invoice(int id, double amount, String title, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class Customer {
    public static final Customer ORACLE = new Customer("ORACLE");
    public static final Customer SUN = new Customer("SUN");
    private String type;

    public Customer(String type) {
        this.type = type;
    }
}