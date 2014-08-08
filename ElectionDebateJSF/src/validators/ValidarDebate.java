package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import de.data.IDAODebate;
import de.data.memoria.DAODebateMemoria;
import entidades.Debate;

@FacesValidator("validators.ValidarDebate")
public class ValidarDebate implements Validator {

	public ValidarDebate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		IDAODebate daoDebate = new DAODebateMemoria();
		
		String nome = (String) value;
		
		
		for (Debate dbte : daoDebate.listarDebates()) {
			if(dbte.getNome().equals(nome)){
				FacesMessage msg = 
						new FacesMessage("Nome debate incorreto.", 
								"Nome já existente.");
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);
			}
		}
	}
	
	

}
