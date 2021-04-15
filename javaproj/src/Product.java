public class Product extends Demonstrate{
	
		int num1,num2;
		Product(int c, int d,int a,int b){
			super(c,d);
			num1=a;
			num2=b;
		}
		public int product() {
			return num1*num2*x*y;//overriden
		}
		public int addition() {
			return num1+num2;
		}
		
	}

