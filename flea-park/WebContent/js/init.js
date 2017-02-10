(function($) {
	/*
	 * ready
	 */
	$(document).ready(function() {
		$('.carousel').carousel();
		$('.materialboxed').materialbox();
		$('.slider').slider({
			full_width : true,
			height : 400,
			transiction : 200
		});
		$('.scrollspy').scrollSpy();
		$('.modal').modal();
		$('.tooltipped').tooltip({
			delay : 50
		});

		$(".dropdown-button").dropdown();
		$('.parallax').parallax();
		$('.button-collapse').sideNav({
			menuWidth : 400,
			closeOnClick : false
		});
		$('select').material_select();
		$('.datepicker').pickadate({
			selectMonths : true,
			selectYears : 16
		});
	});
	$("select").material_select('destroy');
	// $("a, button,.btn, .btn-floating").addClass("waves-effect");
	height = $(window).height()
	$("#content").css({
		"min-height" : height
	});
})(jQuery); // end of jQuery name space
