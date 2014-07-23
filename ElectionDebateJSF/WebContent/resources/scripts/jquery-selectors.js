function turnBlueToGreen() {
  $("#poem li.blue").removeClass("blue")
                    .addClass("green");
}

function turnGreenToBlue() {
  $("#poem li.green").removeClass("green")
                     .addClass("blue");
}

function hideRed() {
  $("#poem li.red").hide("slow");
}

function showRed() {
  $("#poem li.red").show("slow");
}

function addYellow() {
  $(this).addClass("yellow-bg");
}

function removeYellow() {
  $(this).removeClass("yellow-bg");
}

function highlightMissingValues() {
  removeHighlighting();
  $("#form-1 td input.required[value=]").parent()
                                        .addClass("missing")
                                        .each(addWarningStyle);
  $("#warning-msg.warning").html("Please enter required values");
}

function addWarningStyle() {
  $("#warning-msg").addClass("warning");
}

function removeHighlighting() {
  $("#warning-msg.warning").removeClass("warning").html("");
  $("#form-1 td input.required").parent().removeClass("missing");
}

function zebrafyTables() {
  $("tr:nth-child(even)").toggleClass("gray-bg");
}

function styleTables(tableId, options) {
  tableId = "#" + tableId;
  options = setDefaultOptions(options);
  $(tableId + " caption").addClass(options.captionStyle);
  $(tableId + " tr:first").addClass(options.headingStyle);
  $(tableId + " tr").each(
      function(n) {
        if (n>0) {
          var styleIndex = (n-1) % options.rowStyles.length;
          var style = options.rowStyles[styleIndex];
          $(this).addClass(style);
        }
      }
  );
}

function setDefaultOptions(options) {
  if (!options.captionStyle) {
    options.captionStyle = "";
  }
  if (!options.headingStyle) {
    options.headingStyle = "";
  }
  if (!options.rowStyles) {
    options.rowStyles = [""];
  }
  return(options);
}

function doCoolStyles() {
  styleTables(
      "table2", 
      { captionStyle: "title",
        headingStyle: "heading",
        rowStyles: ["row1", "row2", "row3", "row4"]
       });
  $("#table2 td:first-child").css("text-align", "center");
  $("#table2 td:not(:first-child)").css("text-align", "right");
}

function makeUpperCase(event) {
  $(this).val($(this).val().toUpperCase());
  if (event.keyCode == 40) {
    $("#echo-button").click();
  }
}

function echoText() {
  var msg = 
    "Textfield value is '" + 
    $("#uppercase-field").val() +
    "'.";
  $("#echo-text").html(msg);
}

// Important: to style tables, apply the styling on DOM
// load (i.e., call doCoolStyles directly below). 
// Resizing table cells at runtime does not work reliably 
// in Internet Explorer 7.

$(function() {
    $("#turn-green-button").click(turnBlueToGreen);
    $("#revert-green-button").click(turnGreenToBlue);
    $("#hide-red-button").click(hideRed);
    $("#revert-red-button").click(showRed);
    $("#poem li").hover(addYellow, removeYellow);
    $("#highlight-button").click(highlightMissingValues);
    $("#unhighlight-button").click(removeHighlighting);
    $("#zebra-button").click(zebrafyTables);
    $("#cool-styles-button").click(doCoolStyles);
    $("#uppercase-field").keyup(makeUpperCase);
    $("#echo-button").click(echoText);
});