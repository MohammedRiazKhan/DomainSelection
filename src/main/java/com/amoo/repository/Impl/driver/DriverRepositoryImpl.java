package com.amoo.repository.Impl.driver;

import com.amoo.domain.Driver.Driver;

import java.util.HashSet;
import java.util.Set;

public class
DriverRepositoryImpl implements DriverRepository {

    private static DriverRepositoryImpl repository = null;
            Set<Driver> drivers;

    private DriverRepositoryImpl (){
        this.drivers = new HashSet<>();
    }

    public static DriverRepositoryImpl getDriver(){
        if(repository == null) repository = new DriverRepositoryImpl();
        return repository;
    }

    @Override
    public Driver create(Driver driver) {
        drivers.add(driver);
        return driver;
    }

    @Override
    public Driver read(String s) {
        return search(s);
    }

    @Override
    public Driver update(Driver driver) {
        Driver find = search(driver.getRegistration_no());
        if(drivers.contains(find)){
            drivers.remove(find);
            drivers.add(driver);
        }
        return driver;
    }

    @Override
    public void delete(String s) {
       drivers.remove(search(s));
    }

    @Override
    public Set<Driver> getAll() {
        return drivers;
    }

    public Driver search(String reg_Num){
        return drivers.stream().filter(drivers -> drivers.getRegistration_no() == reg_Num).findAny().orElse(null);
    }
}
