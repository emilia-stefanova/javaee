function validate(objForm) {
	if (objForm.t1.value.length == 0) {
		alert("Please enter Name!");
		objForm.t1.focus();
		return false;
	}

	if (!(isNaN(document.objForm.t1.value))) {
		alert("Name has character only!");
		return false;
	}

	if (objForm.t2.value.length == 0) {
		alert("Please enter Password!");
		objForm.t2.focus();
		return false;
	}

	if (objForm.t3.value.length == 0) {
		alert("Please enter Confirm password!");
		objForm.t3.focus();
		return false;
	}

	if (document.getElementById("t2").value != document.getElementById("t3").value) {
		alert("Confirm Password doesnot match!");
		document.getElementById("t3").focus();
		return false;
	}
	
	if (document.objForm.t2.value != document.objForm.t3.value) {
		alert("Confirm Password doesnot match!");
		document.getElementById("t3").focus();
		return false;
	}


	objForm.t1.value = escaped(objForm.t1.value);
	objForm.t2.value = escaped(objForm.t2.value);
	objForm.t3.value = escaped(objForm.t3.value);

	return true;
}

function escaped(str) {
	return str.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g,
			'&gt;');
}