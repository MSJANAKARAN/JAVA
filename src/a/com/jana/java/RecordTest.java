package a.com.jana.java;

public class RecordTest {

//	A record is a special type of class used to store immutable data.
//	Introduced in java 16
//	A record automatically generates
//	constructor // All args constructor by default
//	getters //in java class, getName(), in record name()
//	equals()
//	hashcode()
//	toString()
//	
//	Records are implicitly final => we cannot extend a record, doesn't support inheritance
//	Records internally extend java.lang.Record => we cannot change that
//	
//	Feature            Class                     Record
//	Mutable             Yes						  No
//	Boilerplate			High					Very Low
//	Equals/HashCode		Manual					  Auto
//	Inheritance         Yes                      No
//	Purpose         Behavior + data			 Data carrier
//	
//	Is record completely immutable?
//		Records are shallowly immutable
//		we cannot change reference as it is final but we can modify object, because object itself is mutable 
//		example:
//			record Order(List<String> items) {}
//			List<String> list= new ArrayList<>();
//			list.add("Laptop");  // list object references a heap memory
//			Order order = new Object(list); // order.items reference same memory. So when we modify list, mutable
//		To make deep immutable(means everything inside immutable)
//	    instead of referencing same memory, we are creating a copy an dreferencing that, so change in list won't affect
//
//			record Order(List<String> items) {
//			public Order{
//				items=list.copyOf(items);
//			   }
//		    }
//
//	Can records have methods?
//		Records can have methods
//
//	Can records have constructors?
//		Records can have constructors. Java automatically creates a constructor whose parameter matches record component
//			record Order(String item) {
//				public Order{
//					if(name==null) 
//						throw error;
//			   }
//			compiler internally
//				//	public Order(String name){
//				//		if(name==null) 
//				//			throw error;
//				//      this.name=name;
//				//   }
//		    }
//	
//	Can records implement interfaces?
//		Records can implement interfaces
//		
//	Can records have instance variables?
//		Records cannot define extra instance fields. only record components are allowed
//	
//	When should we use Records?
//		Perfect for REST API
//			DTO
//			API response
//			Request objects
//		we cannot use for JPA entities, because ORM requires no args constructor, mutable fields.
		
			
	public static void main(String[] args) {

		Record r = new Record(3, 4);
		//calling a method inside record
		System.out.println(r.area());
	}

}
