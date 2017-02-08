/*
 * 공통 사용 함수
 */
function getContextPath() {
	if($('#context_path').val().length > 0) {
		return $('#context_path').val();
	}
	
	return "";
}