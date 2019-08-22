package edu.eci.cvds.tdd.registry;
import java.util.*;
public class Registry {
	private ArrayList<Person> registrados;
	
	public Registry(){
		registrados = new ArrayList<Person>();
	}
	
    public RegisterResult registerVoter(Person p) {

        // TODO Validate person and return real result.
		if (!p.isAlive()){
			return RegisterResult.DEAD;
		}
		else{
			if(p.getAge()>122 ||p.getAge()<0){
				return RegisterResult.INVALID_AGE;
			}
			else if(p.getAge()<18){
				return RegisterResult.UNDERAGE;
			}
			else if (duplicated(p)){
				return RegisterResult.DUPLICATED;
			}
			else{
				registrados.add(p);
				return RegisterResult.VALID;
			}
		}
        
    }
	
	public boolean duplicated(Person p){
		boolean respuesta = false;
		for(int i = 0; i<registrados.size(); i++){
			if(p.getId() == registrados.get(i).getId()){
				respuesta = true;
			}
		}
		return respuesta;
	}
}