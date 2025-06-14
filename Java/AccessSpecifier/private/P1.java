class Demo{
	private void fun(){
		System.out.println("This is a private method");
	}
	void gun(){
		fun();
	}
}
class External{
	public static void main(String[] args){
		Demo obj = new Demo();
		obj.gun();
	}
}
