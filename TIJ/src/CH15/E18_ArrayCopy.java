package CH15;

/****************** Exercise 18 *****************
 * Create and fill an array of BerylliumSphere.
 * Copy this array to a new array and show that it��s
 * a shallow copy.
 ************************************************/

import java.util.*;
import java.lang.reflect.*;

public class E18_ArrayCopy {
	// BerylliumSphere.id is private, so we need to use
	// reflection to alter its value.
	static void setID(BerylliumSphere bs, long value) {
		try {
			Field fid = BerylliumSphere.class.getDeclaredField("id");
			fid.setAccessible(true);
			fid.setLong(bs, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BerylliumSphere[] a = new BerylliumSphere[4];
		Arrays.fill(a, new BerylliumSphere());
		BerylliumSphere[] b = new BerylliumSphere[4];
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("b = " + Arrays.toString(b));
		System.arraycopy(a, 0, b, 0, b.length);
		System.out.println("b = " + Arrays.toString(b));
		// Changing a reference in 'a' will not impact 'b'.
		a[1] = a[3] = new BerylliumSphere();
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("b = " + Arrays.toString(b));
		// Changing an object's state will impact 'b', as well.
		setID(a[0], -1L);
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("b = " + Arrays.toString(b));
	}
}