package gofmodel.Observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

	public void update(Observable o, Object arg) {
		Person p = (Person)arg;
		Person pObject = (Person)o;
        //	System.out.println(p.getName());
		System.out.println(p==pObject);

	}

}
