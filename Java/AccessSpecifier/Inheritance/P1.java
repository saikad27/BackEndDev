//In this code we are gonna check if the an interface can be inherited from a class.

class Parent {

}

interface Child implements Parent{
	void fun();
}

/*
*	NOTE: Remember that an extends keyword is used if both parent and child are same i.e. if both parent
*	and child are classes (or if both parent and child are interfaces). While an implements keyword is used 
*	when both are different.		    
*/

//Conclusion : An interface cannot be inherited from a class.That means a class can never be a parent of an interface
