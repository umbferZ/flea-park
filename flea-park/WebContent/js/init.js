(function($) {
	/*
	 * ready
	 */
	$(document).ready(function() {
		$('.carousel').carousel();
		$('.materialboxed').materialbox();
		$('.slider').slider({
			full_width : true,
			height : $(window).height() - 64,
			transiction : 200
		});
		$('.scrollspy').scrollSpy();
		$('.modal-trigger').leanModal();
		$('.tooltipped').tooltip({
			delay : 50
		});

		$(".dropdown-button").dropdown();
		$('.parallax').parallax();
		$('.button-collapse').sideNav();
		$('select').material_select();
		$('.datepicker').pickadate({
			selectMonths : true,
			selectYears : 16
		});
	});
	$("select").material_select('destroy');
	$("a, button,.btn, .btn-floating").addClass("waves-effect");
	height = $(window).height()
	$("#content").css({
		"min-height" : height
	});
})(jQuery); // end of jQuery name space
