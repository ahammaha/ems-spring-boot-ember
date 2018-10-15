import DS from 'ember-data';

export default DS.Model.extend({
	empId : DS.attr(),
	firstName : DS.attr(),
	lastName : DS.attr(),
	email : DS.attr(),
	password : DS.attr(),
	empType : DS.attr(),
	designation: DS.attr(),
	dateOfJoining: DS.attr()
});