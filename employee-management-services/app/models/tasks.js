import DS from 'ember-data';

export default DS.Model.extend({
	name : DS.attr(),
	description : DS.attr(),
	startDate : DS.attr(),
	endDate : DS.attr(),
	employee : DS.belongsTo("employee")
});