


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="icon" type="image/vnd.microsoft.icon" href="http://www.gstatic.com/codesite/ph/images/phosting.ico">
 
 <script type="text/javascript">
 
 
 
 var codesite_token = "b8b0f64c47b06eae0c45d2f2a738c564";
 
 
 var logged_in_user_email = "robson.medeiros@gmail.com";
 
 
 var relative_base_url = "";
 
 </script>
 
 
 <title>script_nodeProject.sql - 
 filescontrol -
 
 Project Hosting on Google Code</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
 
 <link type="text/css" rel="stylesheet" href="http://www.gstatic.com/codesite/ph/1274223301709965370/css/ph_core.css">
 
 <link type="text/css" rel="stylesheet" href="http://www.gstatic.com/codesite/ph/1274223301709965370/css/ph_detail.css" >
 
 
 <link type="text/css" rel="stylesheet" href="http://www.gstatic.com/codesite/ph/1274223301709965370/css/d_sb_20080522.css" >
 
 
 
<!--[if IE]>
 <link type="text/css" rel="stylesheet" href="http://www.gstatic.com/codesite/ph/1274223301709965370/css/d_ie.css" >
<![endif]-->
 <style type="text/css">
 .menuIcon.off { background: no-repeat url(http://www.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -42px }
 .menuIcon.on { background: no-repeat url(http://www.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 -28px }
 .menuIcon.down { background: no-repeat url(http://www.gstatic.com/codesite/ph/images/dropdown_sprite.gif) 0 0; }
 </style>
</head>
<body class="t4">
 <script type="text/javascript">
 var _gaq = _gaq || [];
 _gaq.push(
 ['siteTracker._setAccount', 'UA-18071-1'],
 ['siteTracker._trackPageview']);
 
 (function() {
 var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
 ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
 (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ga);
 })();
 </script>
 <div id="gaia">
 
 <span>
 
 
 <b>robson.medeiros@gmail.com</b>
 
 
 | <a href="/u/robson.medeiros/" id="projects-dropdown" onclick="return false;"
 ><u>My favorites</u> <small>&#9660;</small></a>
 | <a href="/u/robson.medeiros/" onclick="_CS_click('/gb/ph/profile');" 
 title="Profile, Updates, and Settings"
 ><u>Profile</u></a>
 | <a href="https://www.google.com/accounts/Logout?continue=http%3A%2F%2Fcode.google.com%2Fp%2Ffilescontrol%2Fsource%2Fbrowse%2Ftrunk%2FNode%2FDataBase%2Fscript_nodeProject.sql" 
 onclick="_CS_click('/gb/ph/signout');"
 ><u>Sign out</u></a>
 
 </span>

 </div>
 <div class="gbh" style="left: 0pt;"></div>
 <div class="gbh" style="right: 0pt;"></div>
 
 
 <div style="height: 1px"></div>
<!--[if IE 6]>
<div style="text-align:center;">
Support browsers that contribute to open source, try <a href="http://www.firefox.com">Firefox</a> or <a href="http://www.google.com/chrome">Google Chrome</a>.
</div>
<![endif]-->



 <table style="padding:0px; margin: 20px 0px 0px 0px; width:100%" cellpadding="0" cellspacing="0">
 <tr style="height: 58px;">
 
 <td style="width: 55px; text-align:center;">
 <a href="/p/filescontrol/">
 
 <img src="http://www.gstatic.com/codesite/ph/images/defaultlogo.png" alt="Logo">
 
 </a>
 </td>
 
 <td style="padding-left: 0.5em">
 
 <div id="pname" style="margin: 0px 0px -3px 0px">
 <a href="/p/filescontrol/" style="text-decoration:none; color:#000">filescontrol</a>
 
 </div>
 <div id="psum">
 <i><a id="project_summary_link" href="/p/filescontrol/" style="text-decoration:none; color:#000">Controlador de Arquivos Distribuídos</a></i>
 </div>
 
 </td>
 <td style="white-space:nowrap;text-align:right">
 
 <form action="/hosting/search">
 <input size="30" name="q" value="">
 <input type="submit" name="projectsearch" value="Search projects" >
 </form>
 
 </tr>
 </table>


 
<table id="mt" cellspacing="0" cellpadding="0" width="100%" border="0">
 <tr>
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/');">
 <div class="tab inactive">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/">Project&nbsp;Home</a>
 </div>
 </div>
 </th><td>&nbsp;&nbsp;</td>
 
 
 
 
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/downloads/list');">
 <div class="tab inactive">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/downloads/list">Downloads</a>
 </div>
 </div>
 </th><td>&nbsp;&nbsp;</td>
 
 
 
 
 
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/w/list');">
 <div class="tab inactive">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/w/list">Wiki</a>
 </div>
 </div>
 </th><td>&nbsp;&nbsp;</td>
 
 
 
 
 
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/issues/list');">
 <div class="tab inactive">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/issues/list">Issues</a>
 </div>
 </div>
 </th><td>&nbsp;&nbsp;</td>
 
 
 
 
 
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/source/checkout');">
 <div class="tab active">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/source/checkout">Source</a>
 </div>
 </div>
 </th><td>&nbsp;&nbsp;</td>
 
 
 <th onclick="if (!cancelBubble) _go('/p/filescontrol/admin');">
 <div class="tab inactive">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <a onclick="cancelBubble=true;" href="/p/filescontrol/admin">Administer</a>
 </div>
 </div>
 </th>
 <td width="100%">&nbsp;</td>
 </tr>
</table>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0" class="st">
 <tr>
 
 
 
 
 
 
 <td>
 <div class="st2">
 <div class="isf">
 
 
 
 <span class="inst1"><a href="/p/filescontrol/source/checkout">Checkout</a></span> |
 <span class="inst2"><a href="/p/filescontrol/source/browse/">Browse</a></span> |
 <span class="inst3"><a href="/p/filescontrol/source/list">Changes</a></span> |
 
 <form action="http://www.google.com/codesearch" method="get" style="display:inline"
 onsubmit="document.getElementById('codesearchq').value = document.getElementById('origq').value + ' package:http://filescontrol\\.googlecode\\.com'">
 <input type="hidden" name="q" id="codesearchq" value="">
 <input maxlength="2048" size="38" id="origq" name="origq" value="" title="Google Code Search" style="font-size:92%">&nbsp;<input type="submit" value="Search Trunk" name="btnG" style="font-size:92%">
 
  |
 <a href="/p/filescontrol/issues/entry?show=review&former=sourcelist">Request code review</a>
 
 
 </form>
 </div>
</div>

 </td>
 
 
 
 <td height="4" align="right" valign="top" class="bevel-right">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 </td>
 </tr>
</table>
<script type="text/javascript">
 var cancelBubble = false;
 function _go(url) { document.location = url; }
</script>


<div id="maincol"
 
>

 
<!-- IE -->




<div class="expand">


<style type="text/css">
 #file_flipper { display: inline; float: right; white-space: nowrap; }
 #file_flipper.hidden { display: none; }
 #file_flipper .pagelink { color: #0000CC; text-decoration: underline; }
 #file_flipper #visiblefiles { padding-left: 0.5em; padding-right: 0.5em; }
</style>
<div id="nav_and_rev" class="heading">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner" id="bub">
 <div class="bub-top">
 <div class="pagination" style="margin-left: 2em">
 <table cellpadding="0" cellspacing="0" class="flipper">
 <tbody>
 <tr>
 
 <td><b>r93</b></td>
 
 </tr>
 </tbody>
 </table>
 </div>
 
 <div class="" style="vertical-align: top">
 <div class="src_crumbs src_nav">
 <strong class="src_nav">Source path:&nbsp;</strong>
 <span id="crumb_root">
 
 <a href="/p/filescontrol/source/browse/">svn</a>/&nbsp;</span>
 <span id="crumb_links" class="ifClosed"><a href="/p/filescontrol/source/browse/trunk/">trunk</a><span class="sp">/&nbsp;</span><a href="/p/filescontrol/source/browse/trunk/Node/">Node</a><span class="sp">/&nbsp;</span><a href="/p/filescontrol/source/browse/trunk/Node/DataBase/">DataBase</a><span class="sp">/&nbsp;</span>script_nodeProject.sql</span>
 
 
 </div>
 
 </div>
 <div style="clear:both"></div>
 </div>
 </div>
</div>

<style type="text/css">
 
  tr.inline_comment {
 background: #fff;
 vertical-align: top;
 }
 div.draft, div.published {
 padding: .3em;
 border: 1px solid #999; 
 margin-bottom: .1em;
 font-family: arial, sans-serif;
 max-width: 60em;
 }
 div.draft {
 background: #ffa;
 } 
 div.published {
 background: #e5ecf9;
 }
 div.published .body, div.draft .body {
 padding: .5em .1em .1em .1em;
 max-width: 60em;
 white-space: pre-wrap;
 white-space: -moz-pre-wrap;
 white-space: -pre-wrap;
 white-space: -o-pre-wrap;
 word-wrap: break-word;
 }
 div.draft .actions {
 margin-left: 1em;
 font-size: 90%;
 }
 div.draft form {
 padding: .5em .5em .5em 0;
 }
 div.draft textarea, div.published textarea {
 width: 95%;
 height: 10em;
 font-family: arial, sans-serif;
 margin-bottom: .5em;
 }


 
 .nocursor, .nocursor td, .cursor_hidden, .cursor_hidden td {
 background-color: white;
 height: 2px;
 }
 .cursor, .cursor td {
 background-color: darkblue;
 height: 2px;
 display: '';
 }

</style>
<div class="fc">
 
 
 
<style type="text/css">
.undermouse span { 
 background-image: url(http://www.gstatic.com/codesite/ph/images/comments.gif); }
</style>
<table class="opened" id="review_comment_area" 
onmouseout="gutterOut()"><tr>
<td id="nums">
<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>

<pre><table width="100%" id="nums_table_0"><tr id="gr_svn78_1"

 onmouseover="gutterOver(1)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',1);">&nbsp;</span
></td><td id="1"><a href="#1">1</a></td></tr
><tr id="gr_svn78_2"

 onmouseover="gutterOver(2)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',2);">&nbsp;</span
></td><td id="2"><a href="#2">2</a></td></tr
><tr id="gr_svn78_3"

 onmouseover="gutterOver(3)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',3);">&nbsp;</span
></td><td id="3"><a href="#3">3</a></td></tr
><tr id="gr_svn78_4"

 onmouseover="gutterOver(4)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',4);">&nbsp;</span
></td><td id="4"><a href="#4">4</a></td></tr
><tr id="gr_svn78_5"

 onmouseover="gutterOver(5)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',5);">&nbsp;</span
></td><td id="5"><a href="#5">5</a></td></tr
><tr id="gr_svn78_6"

 onmouseover="gutterOver(6)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',6);">&nbsp;</span
></td><td id="6"><a href="#6">6</a></td></tr
><tr id="gr_svn78_7"

 onmouseover="gutterOver(7)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',7);">&nbsp;</span
></td><td id="7"><a href="#7">7</a></td></tr
><tr id="gr_svn78_8"

 onmouseover="gutterOver(8)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',8);">&nbsp;</span
></td><td id="8"><a href="#8">8</a></td></tr
><tr id="gr_svn78_9"

 onmouseover="gutterOver(9)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',9);">&nbsp;</span
></td><td id="9"><a href="#9">9</a></td></tr
><tr id="gr_svn78_10"

 onmouseover="gutterOver(10)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',10);">&nbsp;</span
></td><td id="10"><a href="#10">10</a></td></tr
><tr id="gr_svn78_11"

 onmouseover="gutterOver(11)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',11);">&nbsp;</span
></td><td id="11"><a href="#11">11</a></td></tr
><tr id="gr_svn78_12"

 onmouseover="gutterOver(12)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',12);">&nbsp;</span
></td><td id="12"><a href="#12">12</a></td></tr
><tr id="gr_svn78_13"

 onmouseover="gutterOver(13)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',13);">&nbsp;</span
></td><td id="13"><a href="#13">13</a></td></tr
><tr id="gr_svn78_14"

 onmouseover="gutterOver(14)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',14);">&nbsp;</span
></td><td id="14"><a href="#14">14</a></td></tr
><tr id="gr_svn78_15"

 onmouseover="gutterOver(15)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',15);">&nbsp;</span
></td><td id="15"><a href="#15">15</a></td></tr
><tr id="gr_svn78_16"

 onmouseover="gutterOver(16)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',16);">&nbsp;</span
></td><td id="16"><a href="#16">16</a></td></tr
><tr id="gr_svn78_17"

 onmouseover="gutterOver(17)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',17);">&nbsp;</span
></td><td id="17"><a href="#17">17</a></td></tr
><tr id="gr_svn78_18"

 onmouseover="gutterOver(18)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',18);">&nbsp;</span
></td><td id="18"><a href="#18">18</a></td></tr
><tr id="gr_svn78_19"

 onmouseover="gutterOver(19)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',19);">&nbsp;</span
></td><td id="19"><a href="#19">19</a></td></tr
><tr id="gr_svn78_20"

 onmouseover="gutterOver(20)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',20);">&nbsp;</span
></td><td id="20"><a href="#20">20</a></td></tr
><tr id="gr_svn78_21"

 onmouseover="gutterOver(21)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',21);">&nbsp;</span
></td><td id="21"><a href="#21">21</a></td></tr
><tr id="gr_svn78_22"

 onmouseover="gutterOver(22)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',22);">&nbsp;</span
></td><td id="22"><a href="#22">22</a></td></tr
><tr id="gr_svn78_23"

 onmouseover="gutterOver(23)"

><td><span title="Add comment" onclick="CR_startEdit('svn78',23);">&nbsp;</span
></td><td id="23"><a href="#23">23</a></td></tr
></table></pre>

<pre><table width="100%"><tr class="nocursor"><td></td></tr></table></pre>
</td>
<td id="lines">
<pre class="prettyprint"><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>

<pre class="prettyprint lang-sql"><table id="src_table_0"><tr
id=sl_svn78_1

 onmouseover="gutterOver(1)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_2

 onmouseover="gutterOver(2)"

><td class="source">-- Create tables section -------------------------------------------------<br></td></tr
><tr
id=sl_svn78_3

 onmouseover="gutterOver(3)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_4

 onmouseover="gutterOver(4)"

><td class="source">-- Table Chunk<br></td></tr
><tr
id=sl_svn78_5

 onmouseover="gutterOver(5)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_6

 onmouseover="gutterOver(6)"

><td class="source">CREATE TABLE &quot;chunk&quot;(<br></td></tr
><tr
id=sl_svn78_7

 onmouseover="gutterOver(7)"

><td class="source"> &quot;id&quot; Serial NOT NULL,<br></td></tr
><tr
id=sl_svn78_8

 onmouseover="gutterOver(8)"

><td class="source"> &quot;file_id&quot; Integer NOT NULL,<br></td></tr
><tr
id=sl_svn78_9

 onmouseover="gutterOver(9)"

><td class="source"> &quot;stream&quot; Bytea NOT NULL<br></td></tr
><tr
id=sl_svn78_10

 onmouseover="gutterOver(10)"

><td class="source">)<br></td></tr
><tr
id=sl_svn78_11

 onmouseover="gutterOver(11)"

><td class="source">WITHOUT OIDS<br></td></tr
><tr
id=sl_svn78_12

 onmouseover="gutterOver(12)"

><td class="source">;<br></td></tr
><tr
id=sl_svn78_13

 onmouseover="gutterOver(13)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_14

 onmouseover="gutterOver(14)"

><td class="source">-- Add keys for table Chunk<br></td></tr
><tr
id=sl_svn78_15

 onmouseover="gutterOver(15)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_16

 onmouseover="gutterOver(16)"

><td class="source">ALTER TABLE &quot;chunk&quot; ADD CONSTRAINT &quot;Key3&quot; PRIMARY KEY (&quot;id&quot;)<br></td></tr
><tr
id=sl_svn78_17

 onmouseover="gutterOver(17)"

><td class="source">;<br></td></tr
><tr
id=sl_svn78_18

 onmouseover="gutterOver(18)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_19

 onmouseover="gutterOver(19)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_20

 onmouseover="gutterOver(20)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_21

 onmouseover="gutterOver(21)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_22

 onmouseover="gutterOver(22)"

><td class="source"><br></td></tr
><tr
id=sl_svn78_23

 onmouseover="gutterOver(23)"

><td class="source"><br></td></tr
></table></pre>

<pre class="prettyprint"><table width="100%"><tr class="cursor_stop cursor_hidden"><td></td></tr></table></pre>
</td>
</tr></table>
<script type="text/javascript">
 var lineNumUnderMouse = -1;
 
 function gutterOver(num) {
 gutterOut();
 var newTR = document.getElementById('gr_svn78_' + num);
 if (newTR) {
 newTR.className = 'undermouse';
 }
 lineNumUnderMouse = num;
 }
 function gutterOut() {
 if (lineNumUnderMouse != -1) {
 var oldTR = document.getElementById(
 'gr_svn78_' + lineNumUnderMouse);
 if (oldTR) {
 oldTR.className = '';
 }
 lineNumUnderMouse = -1;
 }
 }
 var numsGenState = {table_base_id: 'nums_table_'};
 var srcGenState = {table_base_id: 'src_table_'};
 var alignerRunning = false;
 var startOver = false;
 function setLineNumberHeights() {
 if (alignerRunning) {
 startOver = true;
 return;
 }
 numsGenState.chunk_id = 0;
 numsGenState.table = document.getElementById('nums_table_0');
 numsGenState.row_num = 0;
 srcGenState.chunk_id = 0;
 srcGenState.table = document.getElementById('src_table_0');
 srcGenState.row_num = 0;
 alignerRunning = true;
 continueToSetLineNumberHeights();
 }
 function rowGenerator(genState) {
 if (genState.row_num < genState.table.rows.length) {
 var currentRow = genState.table.rows[genState.row_num];
 genState.row_num++;
 return currentRow;
 }
 var newTable = document.getElementById(
 genState.table_base_id + (genState.chunk_id + 1));
 if (newTable) {
 genState.chunk_id++;
 genState.row_num = 0;
 genState.table = newTable;
 return genState.table.rows[0];
 }
 return null;
 }
 var MAX_ROWS_PER_PASS = 1000;
 function continueToSetLineNumberHeights() {
 var rowsInThisPass = 0;
 var numRow = 1;
 var srcRow = 1;
 while (numRow && srcRow && rowsInThisPass < MAX_ROWS_PER_PASS) {
 numRow = rowGenerator(numsGenState);
 srcRow = rowGenerator(srcGenState);
 rowsInThisPass++;
 if (numRow && srcRow) {
 if (numRow.offsetHeight != srcRow.offsetHeight) {
 numRow.firstChild.style.height = srcRow.offsetHeight + 'px';
 }
 }
 }
 if (rowsInThisPass >= MAX_ROWS_PER_PASS) {
 setTimeout(continueToSetLineNumberHeights, 10);
 } else {
 alignerRunning = false;
 if (startOver) {
 startOver = false;
 setTimeout(setLineNumberHeights, 500);
 }
 }
 }
 // Do 2 complete passes, because there can be races
 // between this code and prettify.
 startOver = true;
 setTimeout(setLineNumberHeights, 250);
 window.onresize = setLineNumberHeights;
</script>

 
 
 <div id="log">
 <div style="text-align:right">
 <a class="ifCollapse" href="#" onclick="_toggleMeta('', 'p', 'filescontrol', this)">Show details</a>
 <a class="ifExpand" href="#" onclick="_toggleMeta('', 'p', 'filescontrol', this)">Hide details</a>
 </div>
 <div class="ifExpand">
 
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="changelog">
 <p>Change log</p>
 <div>
 <a href="/p/filescontrol/source/detail?spec=svn93&r=78">r78</a>
 by salvinhu
 on Yesterday (25 hours ago)
 &nbsp; <a href="/p/filescontrol/source/diff?spec=svn93&r=78&amp;format=side&amp;path=/trunk/Node/DataBase/script_nodeProject.sql&amp;old_path=/trunk/Node/DataBase/script_nodeProject.sql&amp;old=">Diff</a>
 </div>
 <pre>[No log message]</pre>
 </div>
 
 
 
 
 
 
 <script type="text/javascript">
 var detail_url = '/p/filescontrol/source/detail?r=78&spec=svn93';
 var publish_url = '/p/filescontrol/source/detail?r=78&spec=svn93#publish';
 // describe the paths of this revision in javascript.
 var changed_paths = [];
 var changed_urls = [];
 
 changed_paths.push('/trunk/Node/.classpath');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.classpath?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.project');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.project?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings/org.eclipse.jdt.core.prefs');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.jdt.core.prefs?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings/org.eclipse.jpt.core.prefs');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.jpt.core.prefs?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings/org.eclipse.wst.common.component');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.component?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.prefs.xml');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.prefs.xml?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.xml');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.xml?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/DataBase');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/DataBase?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/DataBase/script_nodeProject.sql');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/DataBase/script_nodeProject.sql?r=78&spec=svn93');
 
 var selected_path = '/trunk/Node/DataBase/script_nodeProject.sql';
 
 
 changed_paths.push('/trunk/Node/libs');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/antlr-2.7.6.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/antlr-2.7.6.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-beanutils.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-beanutils.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-codec-1.3.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-codec-1.3.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-collections-3.1.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-collections-3.1.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-collections.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-collections.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-digester.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-digester.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-fileupload-1.2.1.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-fileupload-1.2.1.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-httpclient-3.0.1.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-httpclient-3.0.1.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/commons-logging.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/commons-logging.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/dom4j-1.6.1.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/dom4j-1.6.1.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/ejb3-persistence.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/ejb3-persistence.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/hibernate-annotations.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/hibernate-annotations.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/hibernate-commons-annotations.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/hibernate-commons-annotations.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/hibernate-entitymanager.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/hibernate-entitymanager.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/hibernate-jpa-2.0-api-1.0.0.Final.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/hibernate-jpa-2.0-api-1.0.0.Final.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/hibernate3.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/hibernate3.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/javassist-3.9.0.GA.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/javassist-3.9.0.GA.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/jta-1.1.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/jta-1.1.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/postgresql-8.3-603.jdbc4.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/postgresql-8.3-603.jdbc4.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/slf4j-api-1.5.6.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/slf4j-api-1.5.6.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/slf4j-api-1.5.8.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/slf4j-api-1.5.8.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/libs/slf4j-simple-1.5.6.jar');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/libs/slf4j-simple-1.5.6.jar?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/META-INF');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/META-INF?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/META-INF/MANIFEST.MF');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/META-INF/MANIFEST.MF?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/META-INF/orm.xml');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/META-INF/orm.xml?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/META-INF/persistence.xml');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/META-INF/persistence.xml?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/business');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/business?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/business/ChunkController.java');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/business/ChunkController.java?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/dao');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/dao/GenericDAO.java');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/GenericDAO.java?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/dao/impl');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/impl?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/dao/impl/ChunkDAO.java');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/impl/ChunkDAO.java?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/entities');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/entities?r=78&spec=svn93');
 
 
 changed_paths.push('/trunk/Node/src/sd/cin/ufpe/br/entities/Chunk.java');
 changed_urls.push('/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/entities/Chunk.java?r=78&spec=svn93');
 
 
 function getCurrentPageIndex() {
 for (var i = 0; i < changed_paths.length; i++) {
 if (selected_path == changed_paths[i]) {
 return i;
 }
 }
 }
 function getNextPage() {
 var i = getCurrentPageIndex();
 if (i < changed_paths.length - 1) {
 return changed_urls[i + 1];
 }
 return null;
 }
 function getPreviousPage() {
 var i = getCurrentPageIndex();
 if (i > 0) {
 return changed_urls[i - 1];
 }
 return null;
 }
 function gotoNextPage() {
 var page = getNextPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoPreviousPage() {
 var page = getPreviousPage();
 if (!page) {
 page = detail_url;
 }
 window.location = page;
 }
 function gotoDetailPage() {
 window.location = detail_url;
 }
 function gotoPublishPage() {
 window.location = publish_url;
 }
</script>
 
 <style type="text/css">
 #review_nav {
 border-top: 3px solid white;
 padding-top: 6px;
 margin-top: 1em;
 }
 #review_nav td {
 vertical-align: middle;
 }
 #review_nav select {
 margin: .5em 0;
 }
 </style>
 <div id="review_nav">
 <table><tr><td>Go to:&nbsp;</td><td>
 <select name="files_in_rev" onchange="window.location=this.value">
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.classpath?r=78&amp;spec=svn93"
 
 >/trunk/Node/.classpath</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.project?r=78&amp;spec=svn93"
 
 >/trunk/Node/.project</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings?r=78&amp;spec=svn93"
 
 >/trunk/Node/.settings</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.jdt.core.prefs?r=78&amp;spec=svn93"
 
 >...tings/org.eclipse.jdt.core.prefs</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.jpt.core.prefs?r=78&amp;spec=svn93"
 
 >...tings/org.eclipse.jpt.core.prefs</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.component?r=78&amp;spec=svn93"
 
 >...org.eclipse.wst.common.component</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.prefs.xml?r=78&amp;spec=svn93"
 
 >...mon.project.facet.core.prefs.xml</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/.settings/org.eclipse.wst.common.project.facet.core.xml?r=78&amp;spec=svn93"
 
 >...st.common.project.facet.core.xml</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/DataBase?r=78&amp;spec=svn93"
 
 >/trunk/Node/DataBase</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/DataBase/script_nodeProject.sql?r=78&amp;spec=svn93"
 selected="selected"
 >.../DataBase/script_nodeProject.sql</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs?r=78&amp;spec=svn93"
 
 >/trunk/Node/libs</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/antlr-2.7.6.jar?r=78&amp;spec=svn93"
 
 >/trunk/Node/libs/antlr-2.7.6.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-beanutils.jar?r=78&amp;spec=svn93"
 
 >.../Node/libs/commons-beanutils.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-codec-1.3.jar?r=78&amp;spec=svn93"
 
 >.../Node/libs/commons-codec-1.3.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-collections-3.1.jar?r=78&amp;spec=svn93"
 
 >...libs/commons-collections-3.1.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-collections.jar?r=78&amp;spec=svn93"
 
 >...ode/libs/commons-collections.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-digester.jar?r=78&amp;spec=svn93"
 
 >...k/Node/libs/commons-digester.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-fileupload-1.2.1.jar?r=78&amp;spec=svn93"
 
 >...ibs/commons-fileupload-1.2.1.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-httpclient-3.0.1.jar?r=78&amp;spec=svn93"
 
 >...ibs/commons-httpclient-3.0.1.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/commons-logging.jar?r=78&amp;spec=svn93"
 
 >...nk/Node/libs/commons-logging.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/dom4j-1.6.1.jar?r=78&amp;spec=svn93"
 
 >/trunk/Node/libs/dom4j-1.6.1.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/ejb3-persistence.jar?r=78&amp;spec=svn93"
 
 >...k/Node/libs/ejb3-persistence.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/hibernate-annotations.jar?r=78&amp;spec=svn93"
 
 >...e/libs/hibernate-annotations.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/hibernate-commons-annotations.jar?r=78&amp;spec=svn93"
 
 >...ibernate-commons-annotations.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/hibernate-entitymanager.jar?r=78&amp;spec=svn93"
 
 >...libs/hibernate-entitymanager.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/hibernate-jpa-2.0-api-1.0.0.Final.jar?r=78&amp;spec=svn93"
 
 >...nate-jpa-2.0-api-1.0.0.Final.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/hibernate3.jar?r=78&amp;spec=svn93"
 
 >/trunk/Node/libs/hibernate3.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/javassist-3.9.0.GA.jar?r=78&amp;spec=svn93"
 
 >...Node/libs/javassist-3.9.0.GA.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/jta-1.1.jar?r=78&amp;spec=svn93"
 
 >/trunk/Node/libs/jta-1.1.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/postgresql-8.3-603.jdbc4.jar?r=78&amp;spec=svn93"
 
 >...ibs/postgresql-8.3-603.jdbc4.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/slf4j-api-1.5.6.jar?r=78&amp;spec=svn93"
 
 >...nk/Node/libs/slf4j-api-1.5.6.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/slf4j-api-1.5.8.jar?r=78&amp;spec=svn93"
 
 >...nk/Node/libs/slf4j-api-1.5.8.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/libs/slf4j-simple-1.5.6.jar?r=78&amp;spec=svn93"
 
 >...Node/libs/slf4j-simple-1.5.6.jar</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src?r=78&amp;spec=svn93"
 
 >/trunk/Node/src</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/META-INF?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/META-INF</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/META-INF/MANIFEST.MF?r=78&amp;spec=svn93"
 
 >...nk/Node/src/META-INF/MANIFEST.MF</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/META-INF/orm.xml?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/META-INF/orm.xml</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/META-INF/persistence.xml?r=78&amp;spec=svn93"
 
 >...ode/src/META-INF/persistence.xml</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/sd</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/sd/cin</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/sd/cin/ufpe</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/sd/cin/ufpe/br</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/business?r=78&amp;spec=svn93"
 
 >...Node/src/sd/cin/ufpe/br/business</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/business/ChunkController.java?r=78&amp;spec=svn93"
 
 >...br/business/ChunkController.java</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao?r=78&amp;spec=svn93"
 
 >/trunk/Node/src/sd/cin/ufpe/br/dao</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/GenericDAO.java?r=78&amp;spec=svn93"
 
 >.../cin/ufpe/br/dao/GenericDAO.java</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/impl?r=78&amp;spec=svn93"
 
 >...Node/src/sd/cin/ufpe/br/dao/impl</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/dao/impl/ChunkDAO.java?r=78&amp;spec=svn93"
 
 >...n/ufpe/br/dao/impl/ChunkDAO.java</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/entities?r=78&amp;spec=svn93"
 
 >...Node/src/sd/cin/ufpe/br/entities</option>
 
 <option value="/p/filescontrol/source/browse/trunk/Node/src/sd/cin/ufpe/br/entities/Chunk.java?r=78&amp;spec=svn93"
 
 >.../cin/ufpe/br/entities/Chunk.java</option>
 
 </select>
 </td></tr></table>
 
 
 
 <div id="review_instr" class="closed">
 <a class="ifOpened" href="/p/filescontrol/source/detail?r=78&spec=svn93#publish">Publish your comments</a>
 <div class="ifClosed">Double click a line to add a comment</div>
 </div>
 
 </div>
 
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="older_bubble">
 <p>Older revisions</p>
 
 <a href="/p/filescontrol/source/list?path=/trunk/Node/DataBase/script_nodeProject.sql&start=78">All revisions of this file</a>
 </div>
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 <div class="pmeta_bubble_bg" style="border:1px solid white">
 <div class="round4"></div>
 <div class="round2"></div>
 <div class="round1"></div>
 <div class="box-inner">
 <div id="fileinfo_bubble">
 <p>File info</p>
 
 <div>Size: 308 bytes,
 23 lines</div>
 
 <div><a href="http://filescontrol.googlecode.com/svn/trunk/Node/DataBase/script_nodeProject.sql">View raw file</a></div>
 </div>
 
 </div>
 <div class="round1"></div>
 <div class="round2"></div>
 <div class="round4"></div>
 </div>
 </div>
 </div>


</div>
</div>

 <script src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/prettify/prettify.js"></script>

 <script src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/prettify/lang-sql.js"></script>

<script type="text/javascript">prettyPrint();</script>

<script src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/source_file_scripts.js"></script>

 <script type="text/javascript" src="http://kibbles.googlecode.com/files/kibbles-1.3.1.comp.js"></script>
 <script type="text/javascript">
 var lastStop = null;
 var initilized = false;
 
 function updateCursor(next, prev) {
 if (prev && prev.element) {
 prev.element.className = 'cursor_stop cursor_hidden';
 }
 if (next && next.element) {
 next.element.className = 'cursor_stop cursor';
 lastStop = next.index;
 }
 }
 
 function pubRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initilized) {
 reloadCursors();
 }
 }
 
 function draftRevealed(data) {
 updateCursorForCell(data.cellId, 'cursor_stop cursor_hidden');
 if (initilized) {
 reloadCursors();
 }
 }
 
 function draftDestroyed(data) {
 updateCursorForCell(data.cellId, 'nocursor');
 if (initilized) {
 reloadCursors();
 }
 }
 function reloadCursors() {
 kibbles.skipper.reset();
 loadCursors();
 if (lastStop != null) {
 kibbles.skipper.setCurrentStop(lastStop);
 }
 }
 // possibly the simplest way to insert any newly added comments
 // is to update the class of the corresponding cursor row,
 // then refresh the entire list of rows.
 function updateCursorForCell(cellId, className) {
 var cell = document.getElementById(cellId);
 // we have to go two rows back to find the cursor location
 var row = getPreviousElement(cell.parentNode);
 row.className = className;
 }
 // returns the previous element, ignores text nodes.
 function getPreviousElement(e) {
 var element = e.previousSibling;
 if (element.nodeType == 3) {
 element = element.previousSibling;
 }
 if (element && element.tagName) {
 return element;
 }
 }
 function loadCursors() {
 // register our elements with skipper
 var elements = CR_getElements('*', 'cursor_stop');
 var len = elements.length;
 for (var i = 0; i < len; i++) {
 var element = elements[i]; 
 element.className = 'cursor_stop cursor_hidden';
 kibbles.skipper.append(element);
 }
 }
 function toggleComments() {
 CR_toggleCommentDisplay();
 reloadCursors();
 }
 function keysOnLoadHandler() {
 // setup skipper
 kibbles.skipper.addStopListener(
 kibbles.skipper.LISTENER_TYPE.PRE, updateCursor);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_top', 50);
 // Set the 'offset' option to return the middle of the client area
 // an option can be a static value, or a callback
 kibbles.skipper.setOption('padding_bottom', 100);
 // Register our keys
 kibbles.skipper.addFwdKey("n");
 kibbles.skipper.addRevKey("p");
 kibbles.keys.addKeyPressListener(
 'u', function() { window.location = detail_url; });
 kibbles.keys.addKeyPressListener(
 'r', function() { window.location = detail_url + '#publish'; });
 
 kibbles.keys.addKeyPressListener('j', gotoNextPage);
 kibbles.keys.addKeyPressListener('k', gotoPreviousPage);
 
 
 kibbles.keys.addKeyPressListener('h', toggleComments);
 
 }
 window.onload = function() {keysOnLoadHandler();};
 </script>

<!-- code review support -->
<script src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/code_review_scripts.js"></script>
<script type="text/javascript">
 
 // the comment form template
 var form = '<div class="draft"><div class="header"><span class="title">Draft comment:</span></div>' +
 '<div class="body"><form onsubmit="return false;"><textarea id="$ID">$BODY</textarea><br>$ACTIONS</form></div>' +
 '</div>';
 // the comment "plate" template used for both draft and published comment "plates".
 var draft_comment = '<div class="draft" ondblclick="$ONDBLCLICK">' +
 '<div class="header"><span class="title">Draft comment:</span><span class="actions">$ACTIONS</span></div>' +
 '<pre id="$ID" class="body">$BODY</pre>' +
 '</div>';
 var published_comment = '<div class="published">' +
 '<div class="header"><span class="title"><a href="$PROFILE_URL">$AUTHOR:</a></span><div>' +
 '<pre id="$ID" class="body">$BODY</pre>' +
 '</div>';

 function showPublishInstructions() {
 var element = document.getElementById('review_instr');
 if (element) {
 element.className = 'opened';
 }
 }
 function revsOnLoadHandler() {
 // register our source container with the commenting code
 var paths = {'svn78': '/trunk/Node/DataBase/script_nodeProject.sql'}
 CR_setup('', 'p', 'filescontrol', '', 'svn93', paths,
 'b8b0f64c47b06eae0c45d2f2a738c564', CR_BrowseIntegrationFactory);
 // register our hidden ui elements with the code commenting code ui builder.
 CR_registerLayoutElement('form', form);
 CR_registerLayoutElement('draft_comment', draft_comment);
 CR_registerLayoutElement('published_comment', published_comment);
 
 // register our source container with the commenting code
 // in this case we're registering the container and the revison
 // associated with the contianer which may be the primary revision
 // or may be a previous revision against which the primary revision
 // of the file is being compared.
 CR_registerSourceContainer(document.getElementById('lines'), 'svn78');
 
 CR_registerActivityListener(CR_ACTIVITY_TYPE.REVEAL_DRAFT_PLATE, showPublishInstructions);
 
 CR_registerActivityListener(CR_ACTIVITY_TYPE.REVEAL_PUB_PLATE, pubRevealed);
 CR_registerActivityListener(CR_ACTIVITY_TYPE.REVEAL_DRAFT_PLATE, draftRevealed);
 CR_registerActivityListener(CR_ACTIVITY_TYPE.DISCARD_DRAFT_COMMENT, draftDestroyed);
 
 
 
 
 
 
 
 
 
 var initilized = true;
 reloadCursors();
 }
 window.onload = function() {keysOnLoadHandler(); revsOnLoadHandler();};
</script>
<script type="text/javascript" src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/dit_scripts_20081013.js"></script>

 
 
 <script type="text/javascript" src="http://www.gstatic.com/codesite/ph/1274223301709965370/js/core_scripts_20081103.js"></script>
 <script type="text/javascript" src="/js/codesite_product_dictionary_ph.pack.04102009.js"></script>
 </div>
<div id="footer" dir="ltr">
 
 <div class="text">
 
 &copy;2010 Google -
 <a href="/projecthosting/terms.html">Terms</a> -
 <a href="http://www.google.com/privacy.html">Privacy</a> -
 <a href="/p/support/">Project Hosting Help</a>
 
 </div>
</div>

 <div class="hostedBy" style="margin-top: -20px;">
 <span style="vertical-align: top;">Powered by <a href="http://code.google.com/projecthosting/">Google Project Hosting</a></span>
 </div>
 
 


 
 </body>
</html>

