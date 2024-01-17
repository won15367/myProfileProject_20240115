/**
 * 
 */

function joinCheck() {
	
	if(document.joinForm.mid.value.length == 0) {
		alert("아이디는 필수 입력사항입니다.")
		return;
	}
	
	if(document.joinForm.mpw.value.length == 0) {
		alert("비밀번호는 필수 입력사항입니다.")
		return;
	}
	
	if(document.joinForm.mpw_check.value.length == 0) {
		alert("비밀번호 확인은 필수 입력사항입니다.")
		return;
	}
	
	if(document.joinForm.mpw.value != document.joinForm.mpw_check.value) {
		alert("비밀번호가 일치하지 않습니다")
		return;
	}
	
	if(document.joinForm.mname.value.length == 0) {
		alert("이름은 필수 입력사항입니다.")
		return;
	}
	
	if(document.joinForm.memail.value.length == 0) {
		alert("이메일은 필수 입력사항입니다.")
		return;
	}
	
	document.joinForm.submit();
	
}


function loginCheck() {
	
	if(document.loginForm.mid.value.length == 0) {
		alert("아이디는 필수 입력사항입니다.")
		return;
	}
	
	if(document.loginForm.mpw.value.length == 0) {
		alert("비밀번호는 필수 입력사항입니다.")
		return;
	}
	
	document.loginForm.submit();
	
}

 