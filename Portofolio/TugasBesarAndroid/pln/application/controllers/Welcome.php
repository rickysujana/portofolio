<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Welcome extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function index()
	{
		$this->load->view('welcome_message');
	}
        public function contohApi(){
            $somedata=array("jenal","abidin","jenalabidinkingdom@gmail.com");
            $somedata2=array("gagak","unikom","mahasiswa");
            $data['isi']=$somedata;
            $data['isi2']=$somedata2;
            echo json_encode($data);
        }
        public function client()
	{
		$this->load->view('clientweb');
	}
}
