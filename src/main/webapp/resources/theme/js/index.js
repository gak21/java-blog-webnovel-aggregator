/*// IIFE - Immediately Invoked Function Expression
  (function(yourcode) {

    // The global jQuery object is passed as a parameter
  	yourcode(window.jQuery, window, document);

  }(function($, window, document) {

    // The $ is now locally scoped 

   // Listen for the jQuery ready event on the document
   $(function() {

     // The DOM is ready!

   });

   // The rest of the code goes here!

  }
  }));

*/

$(function() {

    // Checking for CSS 3D transformation support
    $.support.css3d = supportsCSS3D();

    var formContainer = $('#formContainer');

    // Listening for clicks on the ribbon links
    $('.flipLink').click(function(e) {

        // Flipping the forms
        formContainer.toggleClass('flipped');

        // If there is no CSS3 3D support, simply
        // hide the login form (exposing the recover one)
        if (!$.support.css3d) {
            $('#login').toggle();
        }
        e.preventDefault();
    });

    formContainer.find('form').submit(function(e) {
        // Preventing form submissions. If you implement
        // a backend, you will want to remove this code
        e.preventDefault();
    });

    // A helper function that checks for the
    // support of the 3D CSS3 transformations.
    function supportsCSS3D() {
        var props = [
                'perspectiveProperty', 'WebkitPerspective', 'MozPerspective'
            ],
            testDom = document.createElement('a');

        for (var i = 0; i < props.length; i++) {
            if (props[i] in testDom.style) {
                return true;
            }
        }

        return false;
    }
});

$(function() {

    // Get older/latest blogs info from server(ajax)
    $("#nav-below a").click(function() {

        // Check what button was clicked next/previous
        var direction = 0;
        var isNext = $(this).attr("rel") == "next"
        direction = (isNext) ? 1 : -1;

        //get page number from DOM
        var page = $("#nav-below").data("page");
        page += direction;

        // Hide button if out of scope
        var btnNext = $("#nav-below li:first-child");
        if (page < 1 || page == 1 && isNext)
            btnNext.animate({
                left: '250px'
            }).toggleClass("hidden");

        //update data in DOM
        $("#nav-below").data("page", page);

        getNewPageAjax(page).done(function(data) {
            // Updates the UI based the ajax result
            if(page%2 == 1)
            	$('#recover > tbody').html(data);
            else
            	$('#login > tbody').html(data);
            
        });
        //alert("The paragraph was clicked."+ page);

        return true;
    });
    // auto-sroll page to anchor
    $('a[href^="#"]').on('click', function(e) {
        e.preventDefault();

        var target = this.hash;
        var $target = $(target);

        $('html, body').stop().animate({
            'scrollTop': $target.offset().top
        }, 900, 'swing');
    });
});

function getNewPageAjax(page) {
    var dynamicData = {};
    dynamicData["page"] = page;
    return $.ajax({
        url: 'indextest.html',
        data: dynamicData
    });
}
