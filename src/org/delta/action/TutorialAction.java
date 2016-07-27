/* ********Tutorila - 05(Understing namespace) 
 * browser --> web.xml(struts filter) -->struts.xml(Action Mapping)-->Action class(ActionMethod and servlice logic)-->return .jsp file.
 * http://localhost:8080/StrutsApp/tutorials/getTutorial.action
 * http://<server>:<port>/<webapp>/<namespace>/<action>.action
 * Using namespace in struts.xml we can group action(same kind of action under one namespace  --/tutorials)
 * 
 ********** Tutorial - 06(A StrutsTag in jsp and a Business Service) 
 * TutorialFinderService class created.
 * 
 * There is two to get variable value from java to jsp
 * 1.Put that variable in session.
 * 2.Using Struts tag.Struts framework has it's own tag library to display value java to jsp. 
 * <%@ taglib prefix="s" uri="/struts-tags" %>
 * 
 * VeryImportant concept
 * -To Display variable outside(Jsp), first you need to make that variable to global with seetter and getter.
 * 
 *********** Tutorial - 07 The valueStack thread safe explanation(No practicle)
 * In servlet and jsp data transmission, servlet doen't create separate path for each request so need to implement thread safe concept.
 * but in struts framework is difference, not need to make thread safe because struts create individual object for each request.
 * For each request it's create new actionclass instance.  
 * Now this actionclass instance(object) needs to take view jsp, 
 * How it's work?-->using valuestack
 * 
 * ValueStack - valueStack is very important object in struts framework.
 *              valuestack is use in struts to save many objects.
 *              As above for each request struts create new actionobject and this all actionobjects store in valuestack.
 *    
 *********** Tutorial - 08 Accessing input parameter(doGet). 
 * Two way to submit paramete from jsp to java (1)Through url(doGet) (2)Through form object(doPost)    
 * 
 *(1)Using doGet method we passing lang parameter 
 *      http://localhost:8080/StrutsApp/tutorials/getTutorial.action?language=english    
 *      -Create global variable in action class with getter and setter
 *      -Automatically english going to copy in actionclass language parameter
 *      -So all this automatic happen in interceptors.
 *      
 *      ->New request with language parameter 
 *      ->Actionobject created for that request on valuestack with declare variable in actionclass and gette and setter
 *      -->Intersepter store request parameter value on actionobject
 *      Note:As many request that many Action objects setting on valuestack.  
 *      
 * *********** Tutorial - 09 post requests to actions(doPost).  
 *      -->Create new searchform.jsp     
 *      -->http://localhost:8080/StrutsApp/searchform.jsp
 *      -->In search.jsp, we created one form with text filed and give that id as "language"
 *      -->also we declared language variable with getter and setter method in action class. so it's automatically save in value.
 *      -->get method or post method don't worry automatic sturts copy value in action class variable as long as have same name and getter and setter method.
 *      -->at paresent we using all html tag but struts2 provide tab too, which has more extra future.
 *      -->Let's use same struts tag inplace of html tag in searchform1.jsp
 *      -->if you use struts form you don't need to add .action in action name.
 *      
 *      
 * 
*/

package org.delta.action;

import org.delta.service.TutorialFinderService;

public class TutorialAction {
	
	String bestTutorialSite;
	private String language;
	
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	public String execute(){
		System.out.println("I'm in Action class");
		System.out.println(getLanguage());
		TutorialFinderService tutorialfinderservice = new TutorialFinderService();
		bestTutorialSite = tutorialfinderservice.getBestTutorialSite();
		return "success";
	}
}
