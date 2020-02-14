package application.statestreet.randomizer;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public interface ClientProxy <INPUT,OUTPUT> {
	
	OUTPUT process(DataOutputStream out,
			DataInputStream in,
			INPUT input);

}
