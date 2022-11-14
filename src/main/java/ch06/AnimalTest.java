package ch06;

import java.util.ArrayList;
//gdhdghfhfh
class Animal{
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}
class Human extends Animal{
	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽습니다. ");
	}
}
class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 걷습니다.");
	}
	public void hunt() {
		System.out.println("호랑이가 사냥을 합니다. ");
	}
}
class Eagle extends Animal {
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아다닙니다.");
	}
	public void fly() {
		System.out.println("독수리가 양 날개를 쭉 펴고 날아다닙니다. ");
	}
}
public class AnimalTest {
	public static void main(String[] args) {
		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		AnimalTest test = new AnimalTest();
		test.movAnimal(hAnimal);
		test.movAnimal(tAnimal);
		test.movAnimal(eAnimal);
		System.out.println("====================");
		
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		
		for(Animal animal:animalList) {
			animal.move();
		}
	}
	public void movAnimal(Animal animal) {
		animal.move();
	}
}
