package sistema;

import facade.Facade;

public class teste {
public static void main(String[] args) throws Exception {
	
	Facade facade = new Facade();
	
	facade.cadastraUsuario("Nazare Tedesco","naza_foguete@hotmail.com" ,"belzinha" ,"17/09/1962");
	facade.cadastraUsuario("Fatima Bernardes","fafa_bernardes@email.com.br" ,"fafa_S2" ,"17/09/1962","resources/fatima.jpg");

	facade.cadastraUsuario("Madonna" ,"madonna@email.com","iamawesome","16/08/1958","resources/madonna.jpg");

	//facade.login("naza_foguete@hotmail.com","belzinha");
			
	facade.login("fafa_bernardes@email.com.br","fafa_S2");

	facade.criaPost ("O Encontro de amanha estara otimo. <imagem>imagens/encontro_vinheta.jpg</imagem> <imagem>imagens/encontro_preview.jpg</imagem> #encontro #SemPreconceito" ,"01/08/2015 20:12:00");
			
	facade.criaPost("Hoje o sol me acordou. Foi muito cansativo sair da cama pois ainda estava com muito sono. Gostaria ter mais tempo para dormir. Ainda bem que tinha tapioca e cuscuz no cafe da manha para dar energia. #cafe #acorda","02/08/2015 09:30:00");
	
	facade.logout();
	facade.login("naza_foguete@hotmail.com","belzinha");
	facade.adicionaAmigo("fafa_bernardes@email.com.br");

	facade.logout();
	facade.login("fafa_bernardes@email.com.br","fafa_S2");

	facade.rejeitaAmizade ("naza_foguete@hotmail.com");
	facade.logout();

	facade.login("madonna@email.com" ,"iamawesome");
	facade.curtirPost("fafa_bernardes@email.com.br",1);

	facade.fechaSistema();
}
}
