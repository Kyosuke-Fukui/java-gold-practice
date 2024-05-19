package nest.summary;

public class Main {

	public static void main(String[] args) {
		/* ①外部クラスから内部クラスへのアクセス方法 */
		InnerClass inner = new Main().new InnerClass();
//		InnerClass inner = new InnerClass(); staticから非staticのためエラー
		inner.privateMethod();
		
		/* ②外部クラスからstatic内部クラスへのアクセス方法 */
		new StaticInnerClass().privateMethod();
		
		/* ③他クラスの内部クラスへのアクセス方法 */
		SampleOuter.SampleInner ins = new SampleOuter().new SampleInner();
		ins.innerMethod();
		
		/* ④他クラスのstatic内部クラスへのアクセス方法 */
		new SampleOuter.SampleStaticInner().innerMethod();
		
//		new SampleOuter().outerMethod();
	}
	
	public void test() {
		InnerClass inner = new InnerClass(); //OK
		inner.privateMethod();
	}
	
	private class InnerClass {
		private void privateMethod() {
			System.out.println("1.inner");
		}
	}

	private static class StaticInnerClass {
		private void privateMethod() {
			System.out.println("2.static inner");
		}
	}
}

class SampleOuter {
	private String val = "sample outer";
    public void outerMethod() {

        new SampleOuter().new SampleInner().innerMethod(); //outerMethodがstaticのときはこちら
        new SampleInner().innerMethod(); //outerMethodが非staticのためOK
        
        new SampleStaticInner().innerMethod();
//      new SampleOuter.SampleStaticInner().innerMethod(); //OK
//      new SampleOuter().new SampleStaticInner().innerMethod(); //エラー
    }
    
    public class SampleInner {
    	private String val = "3.sample inner";
        public void innerMethod() {
            System.out.print(val);
            System.out.println(SampleOuter.this.val); //外部クラスのフィールド参照方法
        }
        
        public static void staticMethod() {
            System.out.print("SE11ではエラー");
        }
    }
    
    public static class SampleStaticInner {
        public void innerMethod() {
            System.out.print("4.sample static inner");
        }
    }
}
