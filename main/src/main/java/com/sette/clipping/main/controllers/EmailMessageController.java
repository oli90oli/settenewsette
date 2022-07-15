package com.sette.clipping.main.controllers;


//import lombok.extern.slf4j.Slf4j;


//@RestController //@Slf4j
//@RequestMapping("/email")
public class EmailMessageController {


//    @Autowired
//    MailService emailService;
//
//    // Sending a simple Email
//    @PostMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details)
//    {
//        String status = emailService.sendSimpleMail(details);
//        System.out.println("Sending mail successfully " + status);
//        return status;
//    }

    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestBody EmailDetails details)
//    {
//        String status = emailService.sendMailWithAttachment(details);
//        System.out.println("Sending mail successfully " + status);
//        return status;
//    }
//    @Autowired
//    MailService mailService;
//
//
//
//
//    @RequestMapping("/email")
//    public String sendSimpleMail(){
//        UsersDto dto = new UsersDto();
//        Users user = new Users();
//        Users userEmail = new Users();
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        Users user1 = modelMapper.map(dto, Users.class);
//        log.info("Saving data {} " + userEmail);
//        user1.setEmail("mihael.josifovski1@gmail.com");
//
//        UsersDto result = modelMapper.map(userEmail, UsersDto.class);
//        log.info("Showing results... {} " + result);
//
//        try {
//            mailService.sendEmail(user);
//            System.out.println(user);
//        } catch (MailException mailException) {
//            System.out.println(mailException);
//        }
//        return String.valueOf(user);
//    }
//    @RequestMapping("/email-attachment")
//    public String sendWithAttachment() throws MessagingException {
//        UsersDto dto = new UsersDto();
//        Users userEmail = new Users();
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        Users user = modelMapper.map(dto, Users.class);
//        log.info("Saving data {} " + userEmail);
//        user.setEmail("mihael.josifovski1@gmail.com");
//
//        UsersDto result = modelMapper.map(userEmail, UsersDto.class);
//        log.info("Showing results... {} " + result);
//
//        try {
//            mailService.sendEmailWithAttachment(user);
//            System.out.println(user);
//        } catch (MailException mailException) {
//            System.out.println(mailException);
//        }
//        return String.valueOf(user);
//
//    }
}
