package javasmmr.zoowsome.models.animals;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;
import javax.xml.stream.*;

import javasmmr.zoowsome.services.factories.animals.Constants;

import java.util.Calendar;

public class Tiger extends Mammal {
	
	public Tiger(double cost, double danger){
		super (cost, danger);
		setNrOfLegs(4);
		setNormalBodyTemp((float) 37.5);
		setPercBodyHair ((float) 95.2 );
		
	}
	
	public Tiger(String name, int nrLegs, float bodyTemp, float bodyHair,double cost, double danger,
			boolean takenCareof){
		super (cost, danger);
		setName(name);
		setNrOfLegs(nrLegs);
		setNormalBodyTemp(bodyTemp);
		setPercBodyHair(bodyHair);
		setTakenCareOf(takenCareof);
	
	}
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammals.Tiger);
	}
	@Override
	public double getPredisposition() {
		 Calendar calObj = Calendar.getInstance();
		 int dayOfMonth = calObj.get(Calendar.DAY_OF_MONTH);
		 int hour = calObj.get(Calendar.HOUR_OF_DAY);
		 if ((dayOfMonth > 12)&& (dayOfMonth<27)){
			 if ((hour>=2)&&(hour<=5)){
				 return 0.3;
			 }else
				 return 0.21;
		 }
		 return 0.17;
		 
	}

}
