angular.module('teamawesome.tasks').factory('TaskSrv', function($http, $q) {
	var _entity = "task";
	var _preUrl = '/csci/rest/' + _entity;
	
	function validateTask(task, shouldExist, cb) {
		if (typeof task === 'undefined' || !task)
			return cb('Task must not be empty.');
		else if (!shouldExist && typeof task.id !== 'undefined' || task.id)
			return cb('Task ID must be empty.');
		else if (shouldExist && typeof task.id === 'undefined' || !task.id)
			return cb('Task ID cannot be empty.');
		else if (typeof task.category !== 'object' || !task.category || !task.category.id)
			return cb('Task category must be a valid category with a valid id.');
		else if (typeof task.description !== 'string' || !task.description)
			return cb('Task description must not be empty.');
		else if (typeof task.payment !== 'number' || !task.payment)
			return cb('Task payment must be a valid non-zero number.');
		else if (typeof task.taskZip !== 'number' || !task.taskZip)
			return cb('Task zip code must be a valid non-zero number.');
		else if (typeof task.deadline !== 'number' || !task.deadline)
			return cb('Task deadline must be a valid date.');
		else
			return cb(null, task);
	}

	var factory = {};
	
	factory.findAll = function() {
		return $http.get(_preUrl + '/all');
	};
	
	factory.findOne = function(id) {
		return $http.get(_preUrl + '/' + id);
	};
	
	factory.create = function(task) {
		return $http.post(_preUrl + '/create', task);
	};
	
	factory.update = function(task) {
		return validateTask(task, true, function(err, task) {
			if (err)
				return $q.defer().reject(err);
			else
				return $http.put(_preUrl + '/update', task);
		});
	};
	
	factory.delete = function(task, id) {
		return $http.delete(_preUrl + '/delete', task);
	};			
	
	return factory;
});