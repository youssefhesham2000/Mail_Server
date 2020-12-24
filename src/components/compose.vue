<template>
  <v-app>
    <div class="tab">
      <v-container class="sender">
        <v-chip
          close-icon="mdi-close-outline"
          color="purple"
          label
          x-large
          outlined
          >sender</v-chip
        >
        <v-menu top :close-on-content-click="closeOnContentClick">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              depressed
              elevation="10"
              outlined
              rounded
              x-large
              v-bind="attrs"
              v-on="on"
            >
              Choose E-Mail
            </v-btn>
          </template>

          <v-list>
            <v-list-item v-for="(item, index) in EMAil" :key="index">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-container>

      <v-container>
        <v-text-field label=" Reciever E-Mail"></v-text-field>
        <v-btn depressed elevation="10" outlined rounded x-large
          >Add Reciever</v-btn
        >
        <v-menu>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              depressed
              elevation="10"
              outlined
              rounded
              x-large
              v-bind="attrs"
              v-on="on"
            >
              choose from contacts
            </v-btn>
          </template>

          <v-list>
            <v-list-item v-for="(item, index) in EMAil" :key="index">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-container>
      <v-container>
        <v-chip color="blue" label outlined x-large>Attachments</v-chip>
        <v-btn
          depressed
          elevation="10"
          outlined
          rounded
          x-large
          v-bind="attrs"
          v-on="on"
        >
          choose Attachments
        </v-btn>
      </v-container>
      <v-container>
        <v-text-field label=" Subject"></v-text-field>
      </v-container>
      <v-container>
        <v-textarea autocomplete="email" label="Email"></v-textarea>
      </v-container>
      <v-container>
        <v-btn depressed elevation="10" outlined rounded x-large> Send</v-btn>
        <v-btn depressed elevation="10" outlined rounded x-large>
          Save as a draft</v-btn
        >
        <v-btn depressed elevation="10" outlined rounded x-large @click="loadDrafts()">
          Load draft</v-btn
        >
      </v-container>
      <v-container v-if="showDrafts">
          <v-data-table
      v-model="selected"
      :headers="headers"
      :items="drafts"
      :single-select="singleSelect"
      item-key="name"
      show-select
      class="elevation-1"
    >
      <template v-slot:top>
        <v-switch
          v-model="singleSelect"
          label="Single select"
          class="pa-3"
        ></v-switch>
        <!-- <v-btn> -->

        <v-btn depressed white class="open" @click="openDraft()"
          >open</v-btn
        >
        <!-- </v-btn> -->
        <v-btn depressed white class="open">Delete</v-btn>

        <br />
      </template>
    </v-data-table>
      </v-container>
    </div>
  </v-app>
</template>

<script>
export default {
  name: "email",

  components: {},
  
  data: () => ({
    showDrafts:false,
     drafts:[],
     headers: [
        {
          text: "reciever",
          align: "start",
          sortable: false,
          value: "reciever",
        },
        { text: "subject", value: "subject", sortable: false },
        { text: "body", value: "body", sortable: false },
        { text: "date", value: "date", sortable: false },
     ]
 }),
methods:{
loadDrafts(){
//call the fetch to get the draft list and store it in drafts
this.showDrafts=true;

}



}

};

</script>
<style scoped>
.sender {
  align-self: center;
  margin-left: 20%;
}
.table {
  margin-left: 400px;
  padding-left: 40px;
}
.tab {
  margin-left: 200px;
}
</style>
