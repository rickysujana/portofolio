<?php

require_once APPPATH . 'libraries/REST_Controller.php';

class Data extends REST_Controller {
	
	public function index(){
         $this->load->model('data_model', 'data');
         $data['data'] = $this->data->all();
    }
	
	public function __construct($config = 'rest') {
		parent::__construct($config);
		$token = $this->post('token');

        if (!$token) {
            $token = $this->get('token');
            if (!$token) {
                $response = array(
                    'status' => 'failed',
                    'error' => 'akses ditolak',
                    'data' => ''
                );
                $this->response($response, REST_Controller::HTTP_UNAUTHORIZED);
            }
        }
        $where = array(
            'token' => $token,
        );
        $this->load->model('user_model', 'user');
        $result = $this->user->get_where($where);
        if (count($result) < 0) {
            $response = array(
                'status' => 'failed',
                'error' => 'token invalid',
                'data' => ''
            );
            $this->response($response, REST_Controller::HTTP_UNAUTHORIZED);
        }
		$this->load->model('data_model', 'data');
	} 
	
	    
	

	
	private function data() {
		// 1.ambil token
		 $where = array(
            'token' => $this->post('token')
        );
		// 2.get user berdasarkan token
		$user = $this->user->get_where($where);
		// 3.dapatkan id user berdasarkan
		log_message('DEBUG',$this->db->last_query());
		$data = array(
			'id_pelanggan' => $this->input->post('id_pelanggan', TRUE),
			'nama' => $this->input->post('nama', TRUE),
			'tanggal' => $this->input->post('tanggal', TRUE),
			'jumlah' => $this->input->post('jumlah', TRUE),
			'foto' => $this->input->post('foto', TRUE),
			'userid' => $user[0]->userid
		);
		
		return $data;
	}
	
	private function status($result) {
		if ($result) {
			$response = array(
				'status' => 'succes',
				'error' => '',
				'data' => $result
			);
			$this->response($response, 200);
		} else {
			$response = array(
				'status' => 'failed',
				'error' => 'terjadi error',
				'data' => ''
			);
			$this->response($response, 500);
		}
		return $response;
	}
	
	public function insert_post() {
		$data = $this->data();
		$result = $this->data->insert($data);
		$this->status($result);
	}
	
	public function update_post() {
		$data = $this->data();
		$id = $this->input->post('id', TRUE);
		$result = $this->data->update($data, $id);
		$this->status($result);
	}
	
	public function delete_post() {
		$id = $this->input->post('id', TRUE);
		$result = $this->data->delete($id);
		$this->status($result);
	}
	
	public function find_get() {
		$id = $this->input->get('id', TRUE);
		$result = $this->data->get($id);
		$this->status($result);
	}
	
	public function all_get() {
		$result = $this->data->all();
		$this->status($result);
	}
	
	public function upload_post() {
        $config['upload_path'] = realpath(APPPATH . '../assets/upload/');
        $config['allowed_types'] = '*';
        $config['max_size'] = 10240 ;//10MB
        $this->load->library('upload', $config);
		$id = $this->input->post('id');
        unlink(realpath(APPPATH . '../assets/upload/'.$id.'.jpg'));//hapus gambar lama
		$result = $this->upload->do_upload('gambar');
		$this->status($result);
    }

	
} 	