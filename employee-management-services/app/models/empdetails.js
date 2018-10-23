import DS from 'ember-data';

export default DS.Model.extend({
	phoneNo:DS.attr(),
	address:DS.attr(),
	dateOfBirth:DS.attr(),
	langKnown:DS.attr(),
	firstName : DS.attr(),
	lastName : DS.attr(),
	empType : DS.attr(),
	designation: DS.attr(),
	dateOfJoining: DS.attr(),
	employee : DS.belongsTo("employee")
});