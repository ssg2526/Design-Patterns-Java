package com.ssg.singleton.breaking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.ssg.singleton.domain.SingletonClassic;


/**
 * The following methods are basically serialization methods to break the singleton pattern by creating a new instance by creating a byte 
 * stream of the object(saving in a file) and then reading the stream of bytes from the file (deserializing) and creating a new object from it.
 * Though this can be prevented by throwing a runtime exception from the constructor of the corresponding class.
 * Uncomment the readResolve method of each singleton pattern to safeguard the code from serialization attacks.
 * Enum Singletons don't require the readResolve method, they are by default safe from serialization attacks.
 */
public class BreakSingletonWithSerialization {
	
	public SingletonClassic breakClassicSingleton(SingletonClassic obj) {
		SingletonClassic sc = null;
		FileOutputStream fout = null;
		FileInputStream fin = null;
		ObjectOutput out = null;
		ObjectInput in = null;
		
		try {
			// Serializing
			fout = new FileOutputStream("./resources/serializedInstancefile.txt");
			out = new ObjectOutputStream(fout);
			out.writeObject(obj);
			
			// Deserializing
			fin = new FileInputStream("./resources/serializedInstancefile.txt");
			in = new ObjectInputStream(fin);
			sc = (SingletonClassic) in.readObject();
			if(sc != obj) {
				sc.setVar("new obj4");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fout != null) {
				try {
					fout.flush();
					fout.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return sc;
	}

}
