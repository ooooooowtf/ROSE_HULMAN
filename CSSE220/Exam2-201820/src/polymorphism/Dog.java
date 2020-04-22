package polymorphism;

public class Dog extends Pets{
	private String name;
	private boolean isEating;

	public Dog(String name) {
		this.name = name;
		this.isEating = false;
	}
	
	@Override
	public void eatFood() {
		System.out.println("Dog " + name + " is eating food.");
		this.isEating = true;
	}

	@Override
	public void doSpecialAbility() {
		System.out.print(this.name + " says: ");
		if (startsWithVowel(this.getName())) {
			System.out.println("Arf!");
		} else {
			System.out.println("Bow wow!");
		}
	}
	
	private boolean startsWithVowel(String s) {
		char ch = Character.toLowerCase(s.charAt(0));
		// When y is the first letter of a word, it isn't a vowel.
		return ch == 'a' || ch == 'e' || ch == 'i' 
				|| ch == 'o' || ch == 'u';
	}	
}
