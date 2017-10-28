package sistema;

import controller.Controller;
import facade.Facade;
import usuario.RankingOfUsers;

public class RedeMaisPop {

	private RankingOfUsers ranking;
	private Facade facade;
	private Controller controller;

	public RedeMaisPop() {

		this.ranking = new RankingOfUsers();
		facade = new Facade();
		controller = new Controller();

	}

	public RankingOfUsers getRanking() {
		return ranking;
	}

	public Facade getFacade() {
		return facade;
	}

	public Controller getController() {
		return controller;
	}

}
