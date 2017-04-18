 <?php
 defined('BASEPATH') OR exit('No direct script access allowed');
 
 class Dashboard extends CI_Controller {
     function __construct(){
         parent::__construct();
		 $this->load->helper('url');   
         $this->load->helper('form');   
         $this->load->library('form_validation'); 
		  $this->load->model('m_data'); 
         $this->simple_login->cek_login();
     }
 
     //Load Halaman dashboard
     public function index() {
		 $data['data_survey'] =  $this->m_data->get()->result_array();   
         $data['jumlah_data']  =  $this->m_data->get()->num_rows();
         $this->load->view('crud/v_dashboard',$data);
		 
     }
	 
	 public function form_insert()   
       {      
            $this->form_validation->set_rules('id_pelanggan','Id Pelanggan');   
            $this->form_validation->set_rules('nama','Nama');   
            $this->form_validation->set_rules('tanggal','Tanggal Survey','required');   
            $this->form_validation->set_rules('jumlah','Jumlah','required');   
            $this->form_validation->set_rules('userid','Id User','required');   
   
            if ($this->form_validation->run() === FALSE)   
            {   
                 $this->load->view('crud/add');   
            }   
            else   
            {      
                 $data['id_pelanggan'] = $this->input->post('id_pelanggan');   
                 $data['nama']  = $this->input->post('nama');   
                 $data['tanggal']  = $this->input->post('tanggal');   
                 $data['jumlah']  = $this->input->post('jumlah');   
                 $data['userid']   = $this->input->post('userid');   
                 $this->m_data->insert($data);   
                 $data['msg']  =  'Data berhasil disimpan';   
                 $this->load->view('crud/add_berhasil',$data);   
            }   
       }   
   
       /* public function ubah($id)   
       {   
            $data['data_survey'] =  $this->m_data->get_id($id)->row_array();   
            $this->load->view('crud/edit',$data);   
       }   
   
       public function ubah_data()   
       {   
            $syarat['id'] = $this->input->post('id');   
            $data['id_pelanggan'] = $this->input->post('id_pelanggan');   
            $data['nama']  = $this->input->post('nama');   
            $data['tanggal']  = $this->input->post('tanggal');   
            $data['jumlah']  = $this->input->post('jumlah');   
            $data['userid']   = $this->input->post('userid');   
            $this->m_data->update_data($data, $syarat);   
            $data['msg']  =  'Data berhasil diubah';   
            $this->load->view('crud/add_berhasil',$data);   
       } */   
	   
	   function edit(){
		   $this->load->model('m_data');
		   $id = $this->uri->segment(3);
		   $data ['data'] = $this->m_data->editdata($id)->row_array();
		   $this->load->view('crud/edit', $data);
	   }
	   
	   function edit_simpan(){
		   $id = $this->input->post('id');
		   $data_data = array(
			'id_pelanggan' => $this->input->post('id_pelanggan'),
			'nama' => $this->input->post('nama'),
			'tanggal' => $this->input->post('tanggal'),
			'jumlah' => $this->input->post('jumlah'),
			'userid' => $this->input->post('userid'));
		   $this->db->where('id',$id);
		   $this->db->update('data', $data_data);
		   redirect('dashboard');
	   }
   
	
       public function hapus($id)   
       {   
            $data['data'] =  $this->m_data->delete($id);   
            $data['msg']  =  'Data berhasil dihapus';   
            $this->load->view('crud/add_berhasil',$data);   
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