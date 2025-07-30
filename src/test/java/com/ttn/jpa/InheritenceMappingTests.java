package com.ttn.jpa;

import com.ttn.jpa.entity.inheritence.joined.ElectricCar;
import com.ttn.jpa.entity.inheritence.joined.PetrolCar;
import com.ttn.jpa.entity.inheritence.singletable.Chimpanzee;
import com.ttn.jpa.entity.inheritence.singletable.Gorilla;
import com.ttn.jpa.entity.inheritence.singletable.Monkey;
import com.ttn.jpa.entity.inheritence.tableperclass.Cat;
import com.ttn.jpa.entity.inheritence.tableperclass.Dog;
import com.ttn.jpa.repository.AnimalRepository;
import com.ttn.jpa.repository.CarRepository;
import com.ttn.jpa.repository.MonkeyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InheritenceMappingTests {
    @Autowired
    MonkeyRepository repository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Test
    public void testSingleInheritance() {
        Gorilla gorilla = new Gorilla();
        gorilla.setExotic(true);
        gorilla.setName("Polo");
        gorilla.setStrengthLevel(94);
        repository.save(gorilla);

        Chimpanzee chimp = new Chimpanzee();
        chimp.setExotic(false);
        chimp.setName("Marco");
        chimp.setToolUsage("stick");
        repository.save(chimp);
    }

    @Test
    public void testJoinedInheritance() {
        ElectricCar ec = new ElectricCar();
        ec.setColor("Blue");
        ec.setBatteryCapacity("30 kWh");
        carRepository.save(ec);

        PetrolCar pc = new PetrolCar();
        pc.setColor("Red");
        pc.setTankCapacity("40 lit");
        carRepository.save(pc);
    }

    @Test
    public void testTablePerClassInheritance() {
        Cat cat = new Cat();
        cat.setName("Lily");
        cat.setLikesCatnip(true);
        animalRepository.save(cat);

        Dog dog = new Dog();
        dog.setName("Tiger");
        dog.setTrainedLevel("army");
        animalRepository.save(dog);
    }
}
