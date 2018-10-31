import Route from '@ember/routing/route';

export default Route.extend({
    setupController(controller){
        controller.set('firstName', "");
        controller.set('lastName','');
        controller.set("email","");
        controller.set('designation', "");
        controller.set("empType","");
        controller.set("eid",undefined);
        controller.set("phoneNo",undefined);
        controller.set("address","");
        controller.set("dateOfBirth",undefined);
        controller.set("langKnown","");
	}	
});