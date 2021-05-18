package edu;

import java.util.Iterator;
import static java.lang.System.*;
//import java.lang.Math;

public class Hash{

	private int length;
	private int size;
	private Object[] arrayStorage;

	//terminal colors
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED   = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	//stadistics
	public int insertedByCollision = 0;

	//constructor
	public Hash(int length) {
		this.length = length;
	  clear();
	}

	//clear
	public void clear(){
		arrayStorage = new Object[ this.length ];
	}

	//check emptyness
	public boolean isEmpty(){
		return (length < 1);
	}

	//insert object
	public int insert(Object obj){

		//generate key
		int key = generateObjectKey( ((Employe) obj).name, ((Employe) obj).id );
		int position = getHashKey(key);

		//check empty space
		if (this.arrayStorage[position] == null){
			this.size++;
			this.arrayStorage[position] = obj;
			return position;
		}
		else{

			int collisions = 1;

			//aplicacion metodo: Dependiente de la clave
			int d = (int) key / this.length;

			//convertir a numero impar
			if (d % 2 == 0) d += 1;

			//iterate till find an empty space
			for(int i = 1; i <= this.length; i++){

				//get new position
				position = getHashKey(key + d*i);

				//check position
				if (this.arrayStorage[position] == null){
					System.out.println(ANSI_YELLOW + "Collision x" + String.valueOf(collisions) + ANSI_RESET);

					//counter
					if (collisions > 0) this.insertedByCollision += 1;

					this.size++;
					this.arrayStorage[position] = obj;
					return position;
				}
				else collisions += 1;

			}

			System.out.println(ANSI_YELLOW + "Collision x" + String.valueOf(collisions) + ANSI_RESET);
			return -1;
		}

	}

	//generate object key from NAME and ID
	private int generateObjectKey(String name, int id){

		int objKey = 0;

		//get name numeric value
		for (int i = 0; i < name.length(); i++){
			objKey += (int) name.charAt(i);
		}

		//add the id
		objKey += id;

		return objKey;
	}

	//calculate hash key
	private int getHashKey(int key){
		return (key % this.length);
	}

	//recover object from NAME and ID
	public Object getObject(String name, int id){

		int key = generateObjectKey( name, id );
		int position = getHashKey(key);
		Object retObj = null;
		Employe iObj = null;

		int collisions = 1;

		//aplicacion metodo: Dependiente de la clave
		int d = (int) key / this.length;

		//convertir a numero impar
		if (d % 2 == 0) d += 1;

		//iterate till find the correct object
		for(int i = 0; i <= this.length; i++){

			//get new position
			position = getHashKey(key + d*i);

			if (this.arrayStorage[position] != null){
				iObj = (Employe) this.arrayStorage[position];

				//check it's the correct one
				if ((iObj.name == name) && (iObj.id == id)){
					retObj = (Object) iObj;
					break;
				}
				else{
					collisions += 1;
					continue;
				}

			}
			else{

				System.out.println("Couldn't find that object.");
				break;
			}

		}

		System.out.println(ANSI_YELLOW + "Collision x" + String.valueOf(collisions) + ANSI_RESET);
		return retObj;
	}

	//getters
	public int getSize(){
		return this.size;
	}
	public int getLength(){
		return this.length;
	}
	public int getInsertedByCollision(){
		return this.insertedByCollision;
	}

	//print queue by recurssion
  public void rec(Hash node) {
		return;
  }

}
