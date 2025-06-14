//In this code we are gonna check if we can create an object of an interface.

interface ConnectionDemo{
	void createStatementDemo();
}

class Child implements ConnectionDemo{
	public void createStatementDemo(){
		System.out.println("Interface method has been implemented.");
	}
}

class Demo{
	ConnectionDemo obj = new ConnectionDemo();
	//obj.createStatementDemo();
}

//Conclusion : We cannot create an object of an interface.
