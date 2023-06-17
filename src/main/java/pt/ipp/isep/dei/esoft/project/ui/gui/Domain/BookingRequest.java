package pt.ipp.isep.dei.esoft.project.ui.gui.Domain;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.time.LocalDateTime;

    public class BookingRequest {
        private Agent agent;
        private Property property;
        private LocalDateTime beginDateTime;
        private LocalDateTime endDateTime;

        public BookingRequest(Agent agent, Property property, LocalDateTime beginDateTime, LocalDateTime endDateTime) {
            this.agent = agent;
            this.property = property;
            this.beginDateTime = beginDateTime;
            this.endDateTime = endDateTime;
        }

        public BookingRequest(LocalDateTime beginDateTime, LocalDateTime endDateTime) {
            this.beginDateTime = beginDateTime;
            this.endDateTime = endDateTime;
        }



        // Getters and setters

        public Agent getAgent() {
            return agent;
        }

        public void setAgent(Agent agent) {
            this.agent = agent;
        }

        public Property getProperty() {
            return property;
        }

        public void setProperty(Property property) {
            this.property = property;
        }

        public LocalDateTime getBeginDateTime() {
            return beginDateTime;
        }

        public void setBeginDateTime(LocalDateTime beginDateTime) {
            this.beginDateTime = beginDateTime;
        }


        public LocalDateTime getEndDateTime() {
            return endDateTime;
        }

        public void setEndDateTime(LocalDateTime endDateTime) {
            this.endDateTime = endDateTime;
        }
    }


