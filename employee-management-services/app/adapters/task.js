import ApplicationAdapter from './application';


export default ApplicationAdapter.extend({
	urlForCreateRecord(modelName, snapshot) {
		let empId=snapshot.belongsTo('employee').id;
		return `${this.host}/employees/${empId}/tasks`; // the url you want
	},
	urlForFindAll(modelName,snapshot){
		let empId=snapshot.adapterOptions.empId;
		return `${this.host}/employees/${empId}/tasks`;
	}
});