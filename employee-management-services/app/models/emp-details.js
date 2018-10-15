import DS from 'ember-data';

export default DS.Model.extend({
	phoneNo:DS.attr(),
	address:DS.attr(),
	dateOfBirth:DS.attr(),
	langKnown:DS.attr()
});