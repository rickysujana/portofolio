<?php
defined('BASEPATH') OR exit('No direct script access allowed');   
  class M_data extends CI_Model {  
     
   function get()   
   {   
     return $this->db->get('data');   
   }  
   
   function get_id($id)   
   {   
     $this->db->where('id', $id);   
     $this->db->select("*");   
     $this->db->from("data");   
     return $this->db->get();   
   }  
   
   function insert($data)   
   {   
     $this->db->insert('data', $data);   
   }  
   
   function delete($id)   
   {   
     $this->db->where('id', $id);   
     $this->db->delete('data');   
   }  
   
   /* function update_data($data, $syarat)   
   {   
     $this->db->where($syarat);   
     $this->db->update('data', $data);   
   } */  

	function editdata($id){
		return $this->db->get_where('data',array('id'=>$id));
	}
  }  