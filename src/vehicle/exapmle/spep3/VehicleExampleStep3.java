package vehicle.exapmle.spep3;

// Абстрактный класс vehicle.exapmle.spep3.Vehicle — общий родитель для всех машин
abstract class Vehicle {
    // Инкапсуляция: поля private, чтобы защитить их от прямого изменения
    private String brand;    // Марка автомобиля
    private int maxSpeed;    // Максимальная скорость в км/ч

    // Конструктор: задаём стартовое состояние объекта
    public Vehicle(String brand, int maxSpeed) {
        // Валидация: марка не должна быть пустой
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Марка не может быть пустой");
        }
        // Валидация: скорость должна быть положительной
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Скорость должна быть положительной");
        }
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    // Геттер для марки
    public String getBrand() {
        return brand;
    }

    // Геттер для максимальной скорости
    public int getMaxSpeed() {
        return maxSpeed;
    }

    // Абстрактный метод: реализации нет, обязателен для переопределения в наследниках
    public abstract void startEngine();
}

// Класс vehicle.exapmle.spep3.ElectricCar — наследник vehicle.exapmle.spep3.Vehicle
class ElectricCar extends Vehicle {
    public ElectricCar(String brand, int maxSpeed) {
        super(brand, maxSpeed); // Вызываем конструктор родителя
    }

    @Override // Переопределяем метод startEngine() под электродвигатель
    public void startEngine() {
        System.out.println(getBrand() + " запускает электродвигатель бесшумно.");
    }
}

// Класс vehicle.exapmle.spep3.GasolineCar — наследник vehicle.exapmle.spep3.Vehicle
class GasolineCar extends Vehicle {
    public GasolineCar(String brand, int maxSpeed) {
        super(brand, maxSpeed); // Вызываем конструктор родителя
    }

    @Override // Переопределяем метод startEngine() под бензиновый двигатель
    public void startEngine() {
        System.out.println(getBrand() + " запускает бензиновый двигатель с рыком.");
    }
}

// Главный класс программы
public class VehicleExampleStep3 {
    public static void main(String[] args) {
        // Работаем через общий тип vehicle.exapmle.spep3.Vehicle
        Vehicle tesla = new ElectricCar("Tesla Model S", 250);
        Vehicle bmw = new GasolineCar("BMW M5", 305);

        // Один и тот же метод — разное поведение (полиморфизм)
        tesla.startEngine(); // Выведет бесшумный запуск
        bmw.startEngine();   // Выведет запуск с рыком

        // Доступ к данным через геттеры (инкапсуляция)
        System.out.println(tesla.getBrand() + " — макс. скорость: " + tesla.getMaxSpeed() + " км/ч");
        System.out.println(bmw.getBrand() + " — макс. скорость: " + bmw.getMaxSpeed() + " км/ч");
    }
}