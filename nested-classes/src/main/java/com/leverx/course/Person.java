package com.leverx.course;

import java.util.Optional;

public class Person {
    private final String name;
    private Phone phone;
    private MobileOperator mobileOperator;
    private static final MobileOperatorDefiner mobileOperatorDefiner = new MobileOperatorDefiner();

    public Person(String name, int phoneNumber) {
        this.name = name;
        this.phone = new Phone(phoneNumber);
    }

    public void getData() {
        mobileOperatorDefiner.define(this);
        System.out.printf("%s with phone number: %d & mobile operator: %s%n", name, phone.phoneNumber, mobileOperator);
    }

    public class Phone {
        private int phoneNumber;

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Phone(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    public static class MobileOperatorDefiner {
        private char firstDigit;

        public void define(Person person) {
            Optional<Phone> optionalPhone = Optional.ofNullable(person.phone);

            optionalPhone.ifPresent(firstDigit -> {
                int phoneNumber = person.phone.phoneNumber;

                String value = String.valueOf(phoneNumber);

                this.firstDigit = value.charAt(0);
            });

            switch (firstDigit) {
                case '1':
                case '2':
                case '3':
                    person.mobileOperator = MobileOperator.A_1;
                    break;
                case '4':
                case '5':
                case '6':
                    person.mobileOperator = MobileOperator.MTC;
                    break;
                case '7':
                case '8':
                case '9':
                    person.mobileOperator = MobileOperator.LIFE;
                    break;
                default:
                    person.mobileOperator = MobileOperator.UNKNOWN;
            }
        }
    }
}
