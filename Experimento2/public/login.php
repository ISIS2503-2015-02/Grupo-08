<?php
/**
 * Created by PhpStorm.
 * User: diego
 * Date: 28/10/15
 * Time: 6:17PM
 */

if($_POST["user"] =="admin" && $_POST["password"] == "123$") {
    echo "true";
} else {
    echo "false";
}