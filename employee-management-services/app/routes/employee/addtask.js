import Route from '@ember/routing/route';

export default Route.extend({
	empId:undefined,
	model(params){
		this.set("empId",params.employee_id);
	},
	setupController(controller){
		let empId=this.get("empId");
		controller.set("empId",empId);
	}
});
