package com.mantou.demo;

public class MotorAdapterTest {
    public static void main(String[] args) {
        Motor motor = (Motor) ReadXML.getObject();
        motor.drive();
    }
}
//目标接口
interface Motor{
    public void drive();
}
//适配者：电能发动机
class ElectricMotor {
    public void eletricDrive(){
        System.out.println("电能驱动！");
    }
}
//适配者：光能发动机
class OpticalMotor {
    public void OpticalDrive(){
        System.out.println("光能驱动！");
    }
}
//电能适配器
class ElectricAdaptee extends  ElectricMotor implements Motor {
    @Override
    public void drive() {
        eletricDrive();
    }
}
//光能适配器
class OpticalAdaptee extends  OpticalMotor implements Motor{
    @Override
    public void drive() {
        OpticalDrive();
    }
}

