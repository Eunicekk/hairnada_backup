// 썸머노트
$('#summernote').summernote({
    placeholder: '내용을 입력해주세요.',
    tabsize: 2,
    height: 450,
    lang: "ko-KR",
    toolbar: [
      ['style', ['style']],
      ['font', ['bold', 'underline', 'clear']],
      ['color', ['color']],
      ['para', ['ul', 'ol', 'paragraph']],
      ['table', ['table']],
      ['insert', ['link', 'picture', 'video']],
      ['view', ['fullscreen', 'codeview', 'help']]
    ]
  });

// 파일 첨부 처리
let $fileInput = $('#file');
let $fileList = $('.file-list');
let $cnt = $('.count');

console.log($fileInput);

$fileInput.on('change', function() {
	let files = this.files;
	console.log(files);
	
	// 파일을 변경하면 원래 선택된 미리보기를 제거한다.
	$fileList.html('');
	
	// 4개를 넘기면 초기화 처리
	if(files.length > 4){
		let dt = new DataTransfer();
		files = dt.files;
		// console.log(files);
		alert("파일은 최대 4개까지만 첨부 가능합니다.");
		$cnt.text(files.length);
		return;
	}

	for (let i = 0; i < files.length; i++) {
		let src = URL.createObjectURL(files[i]);

		$fileList.append(`
			<li>
				<div class="show-img-box">
					<img src=${src}>
				</div>
      			<div class="btn-box">
               		<button type='button' class='img-cancel-btn' data-name='${files[i].name}'>×</button>
            	</div>
			</li>
		`);
	}
	$cnt.text(files.length);

	$('.img-cancel-btn').on('click', function() {
		console.log("클릭!");
		// 버튼의 부모의 부모를 삭제한다.
		$(this).parent().parent().remove();
		/*console.log($fileInput[0].files);*/

		let fileName = $(this).data('name');
		let dt = new DataTransfer();

		for(let i=0; i<$fileInput[0].files.length; i++){
			if(files[i].name !== fileName){
				dt.items.add($fileInput[0].files[i]);
			}
		}
		$fileInput[0].files = dt.files;
		$cnt.text($fileInput[0].files.length);
	});

});