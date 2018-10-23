import DS from 'ember-data';
//import empdetails from 'employee-management-services/models/empdetails';

export default DS.Model.extend({
	empId : DS.attr(),
	password : DS.attr(),
	email : DS.attr(),
	empdetails : DS.belongsTo("empdetails") 
});