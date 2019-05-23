package web1;

public class EmpBean {

	//カプセル化してます。
	private String name = null;
	   private int age = 0;

           public int getAge(){
		      return age;
	}
           //引数として受け取った値をカプセル化しています。
           public void setAge(int age) {
        	   this.age = age;
	}

	             public String getName() {
		             return name;
	}
	             //引数をとして受け取った値をカプセル化してます。
	             public void setName(String name) {
	            	 this.name = name;
	}
}
