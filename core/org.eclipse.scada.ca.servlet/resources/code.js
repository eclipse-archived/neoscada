function selectFactory ( factoryId )
{
	var node = document.getElementById('create_factory_id');
	node.value = factoryId;
	document.getElementById('create_id').focus();
}